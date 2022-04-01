package springMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springMVC.model.Account;
import springMVC.model.AccountDAO;

@Service
@Transactional
public class AccountService {

	@Autowired
	private AccountDAO accountDao;

	public boolean checkLogin(Account users) {
		return accountDao.checkLogin(users);
	}
}
