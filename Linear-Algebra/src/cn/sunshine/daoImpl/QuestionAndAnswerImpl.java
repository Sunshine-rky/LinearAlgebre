package cn.sunshine.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.sunshine.bean.Answer;
//import cn.sunshine.bean.Algorithm;
import cn.sunshine.bean.Question;
import cn.sunshine.dao.QuestionAndAnswer;
import cn.sunshine.util.C3p0Util;

public class QuestionAndAnswerImpl implements QuestionAndAnswer {
	QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
	
	@Override
	public void askQuestion(Question q) {
		// TODO Auto-generated method stub
		String sql="insert into question"+"(u_email,u_name,q_time,q_money,q_title,q_content)"+"values(?,?,?,?,?,?)";
		try {
			qr.update(sql,q.getU_email(),q.getU_name(),q.getQ_time(),q.getQ_money(),q.getQ_title(),q.getQ_content());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Question> findAllQuestion() throws SQLException {
		// TODO Auto-generated method stub
		String sql=" SELECT * FROM question WHERE q_state !='待审核'";
		 List<Question> list= qr.query(sql, new BeanListHandler<Question>(Question.class));
		return list;
	}

	@Override
	public Question showQuestionDetial(Question q) {
		String sql="select * from question where q_title=?";
		//String sql1="select u_role  from user where u_email =? and u_password =?";
		try {
			
			//System.out.println();
			return qr.query(sql,new BeanHandler<Question>(Question.class),q.getQ_title());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void answerQuestion(Answer a) {
		String sql="insert into answer"+"(u_email,u_name,a_time,q_title,a_content)"+"values(?,?,?,?,?)";
		try {
			qr.update(sql,a.getU_email(),a.getU_name(),a.getA_time(),a.getQ_title(),a.getA_content());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateNumber(Answer a) {
		String sql="update question set a_number=a_number+1 where q_title=?";
		try {
			qr.update(sql,a.getQ_title());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Answer> findAllAnswer(Answer a) throws SQLException {
		String sql="select * from answer where q_title=?";
		 List<Answer> list= qr.query(sql, new BeanListHandler<Answer>(Answer.class),a.getQ_title());
			return list;
		
	}

	@Override
	public List<Question> findMyAllQuestion(Question q) throws SQLException {
		String sql="select * from question where u_email=?";
		 List<Question> list= qr.query(sql, new BeanListHandler<Question>(Question.class),q.getU_email());
		
			return list;
	}

	@Override
	public List<Answer> findAllMyAnswerNumber(Answer a) throws SQLException {
		String sql="select * from answer where u_email=?";
		 List<Answer> list= qr.query(sql, new BeanListHandler<Answer>(Answer.class),a.getU_email());
			return list;
	}

	@Override
	public List<Question> findAllMyAnswer(Answer a) throws SQLException {
		
		
		String sql="select * from question where q_title in (SELECT q_title FROM answer WHERE u_email=?);";
		 List<Question> list= qr.query(sql, new BeanListHandler<Question>(Question.class),a.getU_email());
		
			return list;
	}

	@Override
	public void addMoney(Answer a) {
		// TODO Auto-generated method stub
		String sql="UPDATE user SET u_money=u_money+(SELECT q_money FROM question WHERE q_title =?) WHERE u_email=?";
		try {
			qr.update(sql,a.getQ_title(),a.getU_email());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void changeState(Answer a) {
		// TODO Auto-generated method stub
		String sql="UPDATE question set q_state='已解决' WHERE q_title=?";
		try {
			qr.update(sql,a.getQ_title());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Question> checkQuestion() throws SQLException {
		// TODO Auto-generated method stub
				String sql=" SELECT * FROM question WHERE q_state ='待审核'";
				 List<Question> list= qr.query(sql, new BeanListHandler<Question>(Question.class));
				return list;
	}

	@Override
	public void passQuestion(Question q) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sql="UPDATE question set q_state='未解决' WHERE q_title=?";
		try {
			qr.update(sql,q.getQ_title());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delectQuestion(Question q) {
		// TODO Auto-generated method stub
		String sql="DELETE from question where q_title=?";
		try {
		qr.update(sql,q.getQ_title());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delectAnswer(Answer a) {
		// TODO Auto-generated method stub
		String sql="DELETE from answer where a_content=?";
		try {
			qr.update(sql,a.getA_content());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delectAllAnawer(Question q) {
		// TODO Auto-generated method stub
				String sql="DELETE from answer where q_title=?";
				try {
				qr.update(sql,q.getQ_title());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	@Override
	public void SubAnswerNumber(Answer a) {
		// TODO Auto-generated method stub
				String sql="UPDATE question set a_number=a_number-1  WHERE  q_title in (SELECT q_title FROM answer WHERE a_content=?) ";
				System.out.println("hahahahaha");
				try {
					qr.update(sql,a.getA_content());
					System.out.println("hahahahaha1");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

//	@Override
//	public List<Answer> countAnswer(Answer a) throws SQLException {
//		
//		// TODO Auto-generated method stub
//				String sql="select * from answer where q_title=?";
//				 List<Answer> list= qr.query(sql, new BeanListHandler<Answer>(Answer.class),a.getQ_title());
//					return list;
//	}
	
}
	
