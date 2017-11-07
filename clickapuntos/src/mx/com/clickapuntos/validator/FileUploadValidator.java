package mx.com.clickapuntos.validator;

import mx.com.clickapuntos.bean.UploadItem;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FileUploadValidator implements Validator {

	@Override
	public boolean supports(Class form) {
		 return UploadItem.class.isAssignableFrom(form);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UploadItem fileUpload = (UploadItem)target;
        if(fileUpload.getFileData().getSize()==0){
        			errors.rejectValue("fileData", "file.vacio");
              }
        if(fileUpload.getFileData().getSize() > 10000){
        		errors.rejectValue("fileData", "file.excede");
        }

	}

}
