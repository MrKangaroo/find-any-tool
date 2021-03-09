package com.find.any.cloud;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.find.any.core.tool.api.R;
import com.find.any.core.tool.jackson.JacksonUtil;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Sentinel统一限流策略
 *
 * @author Chill
 */
public class BladeBlockExceptionHandler implements BlockExceptionHandler {
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
		// Return 429 (Too Many Requests) by default.
		response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
		response.setContentType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE);
		response.getWriter().print(JacksonUtil.toJson(R.fail(e.getMessage())));
	}
}
