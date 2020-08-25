package com.base.impl.file;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.base.common.BaseException;
import com.base.common.ErrorCodes;
import com.base.impl.pojo.ProcessRequest;
import com.base.impl.utils.Status;

@RestController
public class FileProcessController {
	
	Logger logger = LoggerFactory.getLogger(FileProcessController.class);
	
	@Autowired
	private FileServiceImpl fileServiceImpl;
	
	@RequestMapping(value = "/init/file-process",method = RequestMethod.POST)
	public Map<String, Object> initFileProcess(@RequestBody ProcessRequest processRequest) throws BaseException {
		
		if (processRequest == null) {
			logger.error("file proces Request is null");
			throw new BaseException(ErrorCodes.INVALID_FILE_PROCESS_REQUEST);
		}
		
		if (processRequest.getProcess()==null) {
			logger.error("file proces name is invalid");
			throw new BaseException(ErrorCodes.INVALID_PROCESS);
		}
		
		return fileServiceImpl.initProcess(processRequest);
	}
	
	
	@RequestMapping(value = "/update/file-process",method = RequestMethod.POST)
	public Map<String, Object> updateFileProcess(@RequestParam Integer referenceId, @RequestParam Status status) throws BaseException {
		
		if (referenceId == null) {
			logger.error("referenceId is null");
			throw new BaseException(ErrorCodes.INVALID_REFERENCE_ID);
		}
		
		if (status ==null) {
			logger.error("status is invalid");
			throw new BaseException(ErrorCodes.INVALID_PROCESS_STATUS);
		}
		
		return fileServiceImpl.updateFileProcess(referenceId, status);
	}
	
	@RequestMapping(value = "/get/file-process/status",method = RequestMethod.GET)
	public Map<String, Object> getFileProcessStatus(@RequestParam Integer referenceId) throws BaseException {
		
		if (referenceId == null) {
			logger.error("referenceId is null");
			throw new BaseException(ErrorCodes.INVALID_REFERENCE_ID);
		}
		
		return fileServiceImpl.getFileProcessStatus(referenceId);
	}
}
