package net.magicreal.module.bean.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author: maochangan
 * @date: 2018/8/20 11:08
 * @description:
 */

@Data
public class User implements Serializable {

    @NotNull(message = "不可")
    private Long id;

    @NotEmpty(message = "不可空")
    private String name;

    @NotEmpty(message = "不可空")
    private String pad;



}
