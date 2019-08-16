/**
 * Copyright (C), 2019
 * FileName: ParamsNotNull
 * Author:   zhangjian
 * Date:     2019/8/15 13:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.springboottest.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})//参数级别
@Retention(RetentionPolicy.RUNTIME) //注解保留到运行阶段
public @interface ParamsNotNull {
}
