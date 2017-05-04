package org.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.Form.AuntContactForm;
import org.Form.AuntWorkForm;
import org.dao.AuntDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.model.Aunt;
import org.model.AuntContact;
import org.model.AuntWork;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;

@Service
public class AuntDaoImp implements AuntDao {

	@Override
	public boolean addAunt(Aunt a, final Long[] languageId,
			final Long[] cookingId, final Long[] skillId,
			final Long[] applianceId, final Long[] certificateId,
			final Long[] jobId, final AuntContactForm c, final AuntWorkForm w,
			final String url) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			final Long id = (Long) session.save(a);
			session.doWork(new Work() {
				@Override
				public void execute(Connection conn) throws SQLException {
					String sql1 = "insert into aunt_language(aunt_id,language_id) values(?,?)";
					PreparedStatement stmt1 = conn.prepareStatement(sql1);
					conn.setAutoCommit(false);
					for (Long l : languageId) {
						stmt1.setLong(1, id);
						stmt1.setLong(2, l);
						stmt1.addBatch();
					}
					stmt1.executeBatch();

					String sql2 = "insert into aunt_cooking(aunt_id,cooking_id) values(?,?)";
					PreparedStatement stmt2 = conn.prepareStatement(sql2);
					conn.setAutoCommit(false);
					for (Long l : cookingId) {
						stmt2.setLong(1, id);
						stmt2.setLong(2, l);
						stmt2.addBatch();
					}
					stmt2.executeBatch();

					String sql3 = "insert into aunt_skill(aunt_id,skill_id) values(?,?)";
					PreparedStatement stmt3 = conn.prepareStatement(sql3);
					conn.setAutoCommit(false);
					for (Long l : skillId) {
						stmt3.setLong(1, id);
						stmt3.setLong(2, l);
						stmt3.addBatch();
					}
					stmt3.executeBatch();

					String sql4 = "insert into aunt_appliance(aunt_id,appliance_id) values(?,?)";
					PreparedStatement stmt4 = conn.prepareStatement(sql4);
					conn.setAutoCommit(false);
					for (Long l : applianceId) {
						stmt4.setLong(1, id);
						stmt4.setLong(2, l);
						stmt4.addBatch();
					}
					stmt4.executeBatch();

					String sql5 = "insert into aunt_certificate(aunt_id,certificate_id) values(?,?)";
					PreparedStatement stmt5 = conn.prepareStatement(sql5);
					conn.setAutoCommit(false);
					for (Long l : certificateId) {
						stmt5.setLong(1, id);
						stmt5.setLong(2, l);
						stmt5.addBatch();
					}
					stmt5.executeBatch();

					String sql6 = "insert into aunt_job(aunt_id,job_id) values(?,?)";
					PreparedStatement stmt6 = conn.prepareStatement(sql6);
					conn.setAutoCommit(false);
					for (Long l : jobId) {
						stmt6.setLong(1, id);
						stmt6.setLong(2, l);
						stmt6.addBatch();
					}
					stmt6.executeBatch();

					String sql7 = "insert into aunt_contact(cname,relation,workstatus,cphone,aunt_id) values(?,?,?,?,?)";
					PreparedStatement stmt7 = conn.prepareStatement(sql7);
					conn.setAutoCommit(false);
					for(int i=0;i<c.getCname().length;i++){
						stmt7.setString(1,c.getCname()[i]);
						stmt7.setString(2,c.getRelation()[i]);
						stmt7.setString(3,c.getWorkstatus()[i]);
						stmt7.setString(4,c.getCphone()[i]);
						stmt7.setLong(5,id);
						stmt7.addBatch();
					}
					stmt7.executeBatch();

					String sql8 = "insert into aunt_work(time,work,aunt_id) values(?,?,?)";
					PreparedStatement stmt8 = conn.prepareStatement(sql8);
					conn.setAutoCommit(false);
					for(int i=0;i<w.getTime().length;i++){
						stmt8.setString(1, w.getTime()[i]);
						stmt8.setString(2, w.getWork()[i]);
						stmt8.setLong(3, id);
						stmt8.addBatch();
					}
					stmt8.executeBatch();

					String sql9 = "insert into aunt_photo(url,aunt_id) values(?,?)";
					PreparedStatement stmt9 = conn.prepareStatement(sql9);
					conn.setAutoCommit(false);
					stmt9.setString(1, url);
					stmt9.setLong(2, id);
					stmt9.addBatch();
					stmt9.executeBatch();
				}
			});
			ts.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean deleteAunt(long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Aunt a = (Aunt) session.load(Aunt.class, id);
			session.delete(a);
			
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean updateAunt(Aunt l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List getAuntList() {
		// TODO Auto-generated method stub
		return null;
	}

}
