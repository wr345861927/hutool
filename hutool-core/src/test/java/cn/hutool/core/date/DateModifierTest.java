package cn.hutool.core.date;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateModifierTest {

	@Test
	public void truncateTest() {
		String dateStr = "2017-03-01 22:33:23.123";
		Date date = DateUtil.parse(dateStr);

		// 毫秒
		DateTime begin = DateUtil.truncate(date, DateField.MILLISECOND);
		assertEquals(dateStr, begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));

		// 秒
		begin = DateUtil.truncate(date, DateField.SECOND);
		assertEquals("2017-03-01 22:33:23.000", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));

		// 分
		begin = DateUtil.truncate(date, DateField.MINUTE);
		assertEquals("2017-03-01 22:33:00.000", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));

		// 小时
		begin = DateUtil.truncate(date, DateField.HOUR);
		assertEquals("2017-03-01 22:00:00.000", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));
		begin = DateUtil.truncate(date, DateField.HOUR_OF_DAY);
		assertEquals("2017-03-01 22:00:00.000", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));

		// 上下午，原始日期是22点，上下午的起始就是12点
		begin = DateUtil.truncate(date, DateField.AM_PM);
		assertEquals("2017-03-01 12:00:00.000", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));

		// 天，day of xxx按照day处理
		begin = DateUtil.truncate(date, DateField.DAY_OF_WEEK_IN_MONTH);
		assertEquals("2017-03-01 00:00:00.000", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));
		begin = DateUtil.truncate(date, DateField.DAY_OF_WEEK);
		assertEquals("2017-03-01 00:00:00.000", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));
		begin = DateUtil.truncate(date, DateField.DAY_OF_MONTH);
		assertEquals("2017-03-01 00:00:00.000", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));

		// 星期
		begin = DateUtil.truncate(date, DateField.WEEK_OF_MONTH);
		assertEquals("2017-02-27 00:00:00.000", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));
		begin = DateUtil.truncate(date, DateField.WEEK_OF_YEAR);
		assertEquals("2017-02-27 00:00:00.000", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));

		// 月
		begin = DateUtil.truncate(date, DateField.MONTH);
		assertEquals("2017-03-01 00:00:00.000", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));

		// 年
		begin = DateUtil.truncate(date, DateField.YEAR);
		assertEquals("2017-01-01 00:00:00.000", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));
	}

	@Test
	public void truncateDayOfWeekInMonthTest() {
		String dateStr = "2017-03-01 22:33:23.123";
		Date date = DateUtil.parse(dateStr);

		// 天，day of xxx按照day处理
		DateTime begin = DateUtil.truncate(date, DateField.DAY_OF_WEEK_IN_MONTH);
		assertEquals("2017-03-01 00:00:00.000", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));
	}

	@Test
	public void ceilingTest() {
		String dateStr = "2017-03-01 22:33:23.123";
		Date date = DateUtil.parse(dateStr);

		// 毫秒
		DateTime begin = DateUtil.ceiling(date, DateField.MILLISECOND);
		assertEquals(dateStr, begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));

		// 秒
		begin = DateUtil.ceiling(date, DateField.SECOND);
		assertEquals("2017-03-01 22:33:23.999", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));

		// 分
		begin = DateUtil.ceiling(date, DateField.MINUTE);
		assertEquals("2017-03-01 22:33:59.999", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));

		// 小时
		begin = DateUtil.ceiling(date, DateField.HOUR);
		assertEquals("2017-03-01 22:59:59.999", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));
		begin = DateUtil.ceiling(date, DateField.HOUR_OF_DAY);
		assertEquals("2017-03-01 22:59:59.999", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));

		// 上下午，原始日期是22点，上下午的结束就是23点
		begin = DateUtil.ceiling(date, DateField.AM_PM);
		assertEquals("2017-03-01 23:59:59.999", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));

		// 天，day of xxx按照day处理
		begin = DateUtil.ceiling(date, DateField.DAY_OF_WEEK_IN_MONTH);
		assertEquals("2017-03-01 23:59:59.999", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));
		begin = DateUtil.ceiling(date, DateField.DAY_OF_WEEK);
		assertEquals("2017-03-01 23:59:59.999", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));
		begin = DateUtil.ceiling(date, DateField.DAY_OF_MONTH);
		assertEquals("2017-03-01 23:59:59.999", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));

		// 星期
		begin = DateUtil.ceiling(date, DateField.WEEK_OF_MONTH);
		assertEquals("2017-03-05 23:59:59.999", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));
		begin = DateUtil.ceiling(date, DateField.WEEK_OF_YEAR);
		assertEquals("2017-03-05 23:59:59.999", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));

		// 月
		begin = DateUtil.ceiling(date, DateField.MONTH);
		assertEquals("2017-03-31 23:59:59.999", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));

		// 年
		begin = DateUtil.ceiling(date, DateField.YEAR);
		assertEquals("2017-12-31 23:59:59.999", begin.toString(DatePattern.NORM_DATETIME_MS_PATTERN));
	}
}
