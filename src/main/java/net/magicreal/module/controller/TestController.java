package net.magicreal.module.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import net.magicreal.module.bean.dto.User;
import net.magicreal.module.service.ArService;
import net.magicreal.module.util.projectconfig.JsonResult;
import net.magicreal.module.util.projectconfig.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static net.magicreal.module.util.projectconfig.ConstantInterface.FAIL_MSG;
import static net.magicreal.module.util.projectconfig.ConstantInterface.NO_DATA_MESSAGE;
import static net.magicreal.module.util.projectconfig.ConstantInterface.RESULT_KEY;

/**
 * @author: maochangan
 * @date: 2018/8/18 18:31
 * @description: 测试controller
 */
@RestController
@RequestMapping(value = "")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ArService arService;


    /**
     * @description: 测试
     * @param:
     * @return:
     * @auther: maochangan
     * @date: 2018/8/18 18:44
     */
    @ApiOperation(value = "获取token", notes = "用户登陆获取token")
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "Integer")
    @GetMapping(value = "getToKen")
    public JsonResult getToken(@RequestParam(value = "id" , defaultValue = "") Integer id) {
        try {
            System.out.println(id);
            SerResult<String> result = arService.getToken();
            if (result.isSuccess()) {
                return JsonResult.success().add("token", result.getValue());
            } else {
                return JsonResult.fail().add(RESULT_KEY, FAIL_MSG);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return JsonResult.error();
        }
    }

    /**
     * @description: 测试token
     * @param:
     * @return:
     * @auther: maochangan
     * @date: 2018/8/18 18:51
     */
    @ApiOperation(value = "用户登陆" , notes = "用户登陆")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @GetMapping(value = "")
    public JsonResult test(@Validated @RequestBody User user) {
        try {
            System.out.println("here");
            return JsonResult.success().add("", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return JsonResult.error();
        }
    }

    @GetMapping(value = "testJdbc")
    public JsonResult testJdbc() {
        try {
            SerResult<Integer> result = arService.testJdbc();
            if (result.isSuccess()) {
                return JsonResult.success().add("key", result.getValue());
            } else {
                return JsonResult.fail().add(RESULT_KEY, NO_DATA_MESSAGE);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return JsonResult.error();
        }
    }


}
