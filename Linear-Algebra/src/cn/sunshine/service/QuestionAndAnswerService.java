package cn.sunshine.service;

import java.sql.SQLException;
import java.util.List;

import cn.sunshine.bean.Answer;
import cn.sunshine.bean.Question;

public interface QuestionAndAnswerService {
//提问题
	public  void askQuestion(Question q);
	//把所有问题查出来
	public List<Question> findAllQuestion() throws SQLException;
	//通过问题标题把问题全部显示出来
	public Question showQuestionDetial(Question q);
	//用户回答
	public void answerQuestion(Answer a);
//	//把一个问题的它的答案的个数计算出来
//	public int countAnswer(Answer a) throws SQLException;
	//把某个问题的答案全部遍历出来
	public List<Answer> findAllAnswer(Answer a)  throws SQLException;
	

	//某个用户所有的提问
	public List<Question>  findMyAllQuestion(Question q) throws SQLException;
	
	
	//查出某个用户所有回答的个数
	public int findAllMyAnswerNumber(Answer a)  throws SQLException;
	
	//查出所有用户回答的所有问题
	public List<Question>  findAllMyAnswer(Answer a) throws SQLException;
	
	//提问者采纳回答者的回答，回答者金币数量增加
	public void addMoney(Answer a);
	
	//提问者获得了自己想要的答案，即提问者采纳回答者的回答，问题状态变成已解决
		public void changeState(Answer a);
		
		//遍历出待审核的提问
		public List<Question> checkQuestion() throws SQLException;
	

		//确认通过审核
			public void passQuestion(Question q);
			//问题审核不通过，删除
			public void delectQuestion(Question q);
			//删除不合规提问以及删除这个提问下的所有回答
				public void delectQuestion1(Question q);
				
			//删除不合规的回答,,以及每删除一个回答回答的个数减一
				public void delectAnswer(Answer a);
				public void SubAnswerNumber(Answer a);
}
