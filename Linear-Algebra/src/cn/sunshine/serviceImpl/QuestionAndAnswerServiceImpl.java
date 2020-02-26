package cn.sunshine.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import cn.sunshine.bean.Answer;
import cn.sunshine.bean.Question;
import cn.sunshine.dao.QuestionAndAnswer;
import cn.sunshine.daoImpl.QuestionAndAnswerImpl;
import cn.sunshine.service.QuestionAndAnswerService;

public class QuestionAndAnswerServiceImpl implements QuestionAndAnswerService{
QuestionAndAnswer qa=new QuestionAndAnswerImpl();
@Override
	public void askQuestion(Question q) {
		// TODO Auto-generated method stub
		qa.askQuestion(q);
	}
@Override
public List<Question> findAllQuestion() throws SQLException {
	
	return qa.findAllQuestion();
}
@Override
public Question showQuestionDetial(Question q) {
	
	return qa.showQuestionDetial(q);
}

//用户回答
@Override
public void answerQuestion(Answer a) {
	// TODO Auto-generated method stub
	//向回答表查入数据
	qa.answerQuestion(a);
	//向问题表更新回答的个数
	qa.updateNumber(a);
	
}
//@Override
//public int countAnswer(Answer a) throws SQLException {
//	List<Answer> list=qa.countAnswer(a);
//	return list.size();
//}
@Override
public List<Answer> findAllAnswer(Answer a) throws SQLException {
	// TODO Auto-generated method stub
	return qa.findAllAnswer(a);
}
@Override
public List<Question> findMyAllQuestion(Question q) throws SQLException {
	
	return qa.findMyAllQuestion(q);
}
@Override
public int findAllMyAnswerNumber(Answer a) throws SQLException {
	// TODO Auto-generated method stub
	List<Answer> list=qa.findAllMyAnswerNumber(a);
	int i=list.size();
	return i;
}
@Override
public List<Question> findAllMyAnswer(Answer a) throws SQLException {
	// TODO Auto-generated method stub
	return qa.findAllMyAnswer(a);
}
@Override
public void addMoney(Answer a) {
	qa.addMoney(a);
	
}
@Override
public void changeState(Answer a) {
	// TODO Auto-generated method stub
	qa.changeState(a);
}
@Override
public List<Question> checkQuestion() throws SQLException {
	// TODO Auto-generated method stub
	return qa.checkQuestion();
}
@Override
public void passQuestion(Question q) {
	// TODO Auto-generated method stub
	qa.passQuestion(q);
}
@Override
public void delectQuestion(Question q) {
	// TODO Auto-generated method stub
	qa.delectQuestion(q);
}
@Override
public void delectAnswer(Answer a) {
	// TODO Auto-generated method stub
	qa.delectAnswer(a);
	
//	qa.SubAnswerNumber(a);

}
@Override
public void delectQuestion1(Question q) {
	// TODO Auto-generated method stub
	qa.delectQuestion(q);
	qa.delectAllAnawer(q);

}
@Override
public void SubAnswerNumber(Answer a) {
	// TODO Auto-generated method stub
	qa.SubAnswerNumber(a);
	System.out.println("hyjyujuk");
}

}
