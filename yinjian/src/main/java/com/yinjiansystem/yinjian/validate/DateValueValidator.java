package com.yinjiansystem.yinjian.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;

/**
 * @Description 时间格式校验 实现类
 * @Author DT
 * @Date 2021/1/4
 */
public class DateValueValidator implements ConstraintValidator<DateValue, String> {
	
	private String[] formats;
	
	public void initialize(DateValue constraintAnnotation) {
		formats = constraintAnnotation.format();
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || "".equals(value.trim())) {
			return true;
		}
		if (formats.length == 0) {
			return true;
		}

		for (String string : formats) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat(string);
				formatter.parse(value);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}


}
