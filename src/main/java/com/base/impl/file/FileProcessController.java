package com.base.impl.file;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileProcessController {
	@RequestMapping(value = "/init/file/process")
	public String initFileProcess(Map<String, String> procesRequest) {
		if (procesRequest == null) {

		}
		return "";
	}
}
