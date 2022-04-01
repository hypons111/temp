package springMVC.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import springMVC.model.Picture;
import springMVC.model.PictureService;

@Controller
public class UploadFileController {

	@Autowired
	private PictureService pService;

	@RequestMapping(path = "/uploadmain.controller", method = RequestMethod.GET)
	public String processMainAction() {
		return "uploadFile";
	}

	@RequestMapping(path = "/uploadfile.controller", method = RequestMethod.POST)
	@ResponseBody
	public String processUploadFileAction(@RequestParam("myFiles") MultipartFile mf, HttpServletRequest request)
			throws IllegalStateException, IOException {
		String fileName = mf.getOriginalFilename();

		String saveTempFileDir = request.getSession().getServletContext().getRealPath("/") + "uploadTempDir\\";
		File saveTempDirFile = new File(saveTempFileDir);
		saveTempDirFile.mkdirs();

		// 把圖片傳到資料夾
		String saveFilePath = saveTempFileDir + fileName;
		File saveFile = new File(saveFilePath);
		mf.transferTo(saveFile);
		

		// 也可以用 getBytes() 把圖片資料轉為 byte 儲存到資料庫
//		 mf.getBytes();
		// 把圖片傳到資料庫
		if (fileName != null && fileName.length() != 0) {
			saveFile(fileName, saveFilePath);
		}

		return "saveFilePath:" + saveFilePath;
	}

	private void saveFile(String fileName, String saveFilePath) {
		
		try {
			FileInputStream is1 = new FileInputStream(saveFilePath);
			byte[] b = new byte[is1.available()];
			is1.read(b);
			is1.close();

			Picture picture = new Picture(fileName, b);
			pService.insert(picture);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
