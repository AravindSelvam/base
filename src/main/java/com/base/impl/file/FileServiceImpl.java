package com.base.impl.file;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.common.BaseException;
import com.base.common.ErrorCodes;
import com.base.impl.model.ProcessDetails;
import com.base.impl.pojo.ProcessRequest;
import com.base.impl.utils.Constants;
import com.base.impl.utils.Status;

@Service
public class FileServiceImpl {

	@Autowired
	private IFileServiceDao fileServiceDao;

	Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

	public Map<String, Object> initProcess(ProcessRequest request) {

		logger.info("file process init started for " + request.getFileName());

		ProcessDetails processDetails = new ProcessDetails();
		processDetails.setProcess(request.getProcess().name());
		processDetails.setFileName(request.getFileName());
		processDetails.setUserId(request.hashCode() % 100);
		processDetails.setStatus(Status.INIT.name());

		fileServiceDao.save(processDetails);

		Map<String, Object> res = new HashMap<String, Object>();
		res.put(Constants.REFERENCE_ID, processDetails.getId());
		res.put(Constants.STATUS, Constants.SUCCESS);
		logger.info("file process successfully completed " + processDetails.getId());
		return res;
	}

	public Map<String, Object> updateFileProcess(Integer referenceId, Status status) throws BaseException {
		Optional<ProcessDetails> optional = fileServiceDao.findById(referenceId);

		if (!optional.isPresent()) {
			throw new BaseException(ErrorCodes.INVALID_REFERENCE_ID);
		}

		ProcessDetails processDetails = optional.get();
		processDetails.setStatus(status.name());

		Map<String, Object> res = new HashMap<String, Object>();
		res.put(Constants.REFERENCE_ID, processDetails.getId());
		res.put(Constants.STATUS, Constants.SUCCESS);
		
		fileServiceDao.save(processDetails);
		
		logger.info("file process updated successfully completed " + processDetails.getId());
		
		return res;
	}

	public Map<String, Object> getFileProcessStatus(Integer referenceId) throws BaseException {
		Optional<ProcessDetails> optional = fileServiceDao.findById(referenceId);

		if (!optional.isPresent()) {
			throw new BaseException(ErrorCodes.INVALID_REFERENCE_ID);
		}

		ProcessDetails processDetails = optional.get();

		Map<String, Object> res = new HashMap<String, Object>();
		res.put(Constants.REFERENCE_ID, processDetails.getId());
		res.put(Constants.PROCESS_STATUS, processDetails.getStatus());
		res.put(Constants.STATUS, Constants.SUCCESS);
		
		return res;
	}

}
