package com.find.any.core.tool.convert;

import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.lang.Nullable;
import org.springframework.util.StringValueResolver;

/**
 * 类型 转换 服务，添加了 IEnum 转换
 *
 * @author L.cm
 */
public class FindAnyConversionService extends ApplicationConversionService {
	@Nullable
	private static volatile FindAnyConversionService SHARED_INSTANCE;

	public FindAnyConversionService() {
		this(null);
	}

	public FindAnyConversionService(@Nullable StringValueResolver embeddedValueResolver) {
		super(embeddedValueResolver);
		super.addConverter(new EnumToStringConverter());
		super.addConverter(new StringToEnumConverter());
	}

	/**
	 * Return a shared default application {@code ConversionService} instance, lazily
	 * building it once needed.
	 * <p>
	 * Note: This method actually returns an {@link FindAnyConversionService}
	 * instance. However, the {@code ConversionService} signature has been preserved for
	 * binary compatibility.
	 * @return the shared {@code BladeConversionService} instance (never{@code null})
	 */
	public static GenericConversionService getInstance() {
		FindAnyConversionService sharedInstance = FindAnyConversionService.SHARED_INSTANCE;
		if (sharedInstance == null) {
			synchronized (FindAnyConversionService.class) {
				sharedInstance = FindAnyConversionService.SHARED_INSTANCE;
				if (sharedInstance == null) {
					sharedInstance = new FindAnyConversionService();
					FindAnyConversionService.SHARED_INSTANCE = sharedInstance;
				}
			}
		}
		return sharedInstance;
	}

}
