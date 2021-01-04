package com.yinjiansystem.yinjian.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Description 注解 时间格式校验
 * @Author DT
 * @Date 2021/1/4
 */
@Documented
@Constraint(validatedBy = { DateValueValidator.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@ReportAsSingleViolation
public @interface DateValue {

	String message() default "日期格式不正确";
	 
	Class<?>[] groups() default { };
 
	Class<? extends Payload>[] payload() default { };
 
	/**
	 * 有效的日期格式
	 */
	String[] format() default {};  
	
	/**
	 * Defines several {@link com.yinjiansystem.yinjian.validate.DateValue} annotations on the same element.
	 *
	 * @see com.yinjiansystem.yinjian.validate.DateValue
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		com.yinjiansystem.yinjian.validate.DateValue[] value();
	}
	
}
