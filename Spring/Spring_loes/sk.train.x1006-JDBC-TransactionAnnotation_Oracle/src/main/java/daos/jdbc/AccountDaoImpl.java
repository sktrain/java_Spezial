package daos.jdbc;

import java.util.List;

import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import daos.AccountDao;
import domain.Account;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	private final RowMapper<Account> mapper = (rs, rowNumber) -> {
		final Account a = new Account();
		a.setNumber(rs.getInt(1));
		a.setBalance(rs.getInt(2));
		return a;
	};

	
	@Override
	public void insert(Account account) {
		final String sql = "insert into account (nr, balance) values (?, ?)";
		final Object result = this.getJdbcTemplate().update(sql, account.getNumber(), account.getBalance());
		if ((Integer) result != 1)
			throw new RuntimeException("cannot insert: " + account);
	}

	@Override
	public void update(Account account) {
		final String sql = "update account set balance = ? where nr = ?";
		final Object result = this.getJdbcTemplate().update(sql, account.getBalance(), account.getNumber());
		if ((Integer) result != 1)
			throw new RuntimeException("cannot update: " + account);
	}

	@Override
	public void delete(Account account) {
		final String sql = "delete from account where nr = ?";
		final Object result = this.getJdbcTemplate().update(sql, account.getNumber());
		if ((Integer) result != 1)
			throw new RuntimeException("cannot delete: " + account);
	}

	@Override
	public Account get(int number) {
		final Account account = this.find(number);
		if (account == null)
			throw new DataRetrievalFailureException("account with number " + number + " not found");
		return account;
	}

	@Override
	public Account find(int number) {
		final String sql = "select nr, balance from account where nr = ?";
		return this.getJdbcTemplate().queryForObject(sql, this.mapper, number);
	}

	@Override
	public List<Account> findAll() {
		final String sql = "select nr, balance from account";
		return this.getJdbcTemplate().query(sql, this.mapper);
	}
}
