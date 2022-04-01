package springMVC.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PictureService {

	@Autowired
	private PictureDao pDao;

	public Picture insert(Picture p) {
		return pDao.insert(p);
	}
}