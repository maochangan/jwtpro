package net.magicreal.module.util.filters;

import io.jsonwebtoken.Claims;
import net.magicreal.module.util.projectconfig.JsonResult;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import static net.magicreal.module.util.projectconfig.ConstantInterface.AUDIENCE_BASE64_SECRET;


/**
 * @author maochangan
 * token验证工具
 */
@WebListener
public class TokenAuthorFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(TokenAuthorFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        response.addHeader("Access-Control-Max-Age", "3600");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        JsonResult jsonResult = new JsonResult();
        jsonResult.setMessage("请登陆");
        jsonResult.setStatus(-1);

        boolean isFilter = false;

        PrintWriter writer;
        OutputStreamWriter osw;

        String token = request.getHeader("token");
        if (token != null) {
            Claims claims = JwtUtils.parseJWT(token, AUDIENCE_BASE64_SECRET);
            if (claims != null) {
                Integer userId = (Integer) claims.get("userId");
                Integer companyId = (Integer) claims.get("companyId");
                request.setAttribute("userId", userId);
                request.setAttribute("companyId", companyId);
                isFilter = true;
            } else {
                jsonResult.setMessage("token异常，请重试");
                osw = new OutputStreamWriter(response.getOutputStream(), StandardCharsets.UTF_8);
                writer = new PrintWriter(osw, true);
                writer.write(String.valueOf(new JSONObject(jsonResult)));
                writer.flush();
                writer.close();
                osw.close();
            }
        } else {
            osw = new OutputStreamWriter(response.getOutputStream(), StandardCharsets.UTF_8);
            writer = new PrintWriter(osw, true);
            writer.write(String.valueOf(new JSONObject(jsonResult)));
            writer.flush();
            writer.close();
            osw.close();
        }
        if (isFilter) {
            logger.info("token filter过滤ok!");
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
