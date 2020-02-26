package cn.sunshine.dao;

import java.sql.SQLException;
import java.util.List;

import cn.sunshine.bean.Answer;
import cn.sunshine.bean.Question;

public interface QuestionAndAnswer {
	
	/*问答模块用户的操作
	 * 思路：
	 * 我把用户问答功能分为
	 *    一：我与所有用户的问答
	 *    				 1查看所有的问答
	 *    					 仅展示问题题目和少量内容，以及用户名，提问时间，回答的个数，以及问题状态，奖赏金币
	 *    				 2查看问题详情(通过点击标题查看问题详情)
	 *    					问题详情：展示问题题目和全部内容，以及用户名，提问时间，以及问题状态，奖赏金币
	 *    					回答详情：还展示所有回答的个数，回答者的姓名，回答时间，回答内容
	 *    				 3我回答问题
	 * 
	 *  二：我自己的问答  
	 * 					1.我要提问
	 * 						填入问题标题
	 * 						填入问题内容
	 * 						填入奖赏金币
	 * 					2.我的问答
	 *   					 我提出的   
	 *   						通过用户的u_email查出所以我提出的问题，并返回一个list集合
	 *   						通过list.size()计算出我提出问题的总数
	 *   						通过点击标题查看问题详情
	 *   						通过点击采纳来说明我已经找到答案
	 *   					我回答的
	 *   						通过用户的u_email查出所以我回答的问题，并返回一个list集合
	 *   						通过list.size()计算出我回答问题的总数
	 *   						通过点击标题查看问题详情
	 *   		  
	 *    
	 *    
	 *注意：因为很多功能都用到了问题标题，故一个问题的标题不能为空且不能重复
	 *    
	 *问答模块与日志管理（问答模块仅仅记录用户的操作）
	 *不管在问答管理的那个操作都属于问答模块
	 *不同的操作有不同的定义
	 *		用户浏览
	 *		查看详情
	 *		回答问题
	 *		用户提问
	 *		
	 *		查看自己提出的所有问题
	 *		查看自己回答所有的问题
	 *		采纳问题
	 *		
	 *
	 *    
	 * */
//提问题
	public void askQuestion(Question q);

//把所有问题查出来
	public List<Question> findAllQuestion() throws SQLException;

//通过问题标题把通过审核的问题全部显示出来
	public Question showQuestionDetial(Question q);

//用户回答
	public void answerQuestion(Answer a);

//用户回答后答案个数+1
	public void updateNumber(Answer a);
////把一个问题的它的答案的个数计算出来
//public List<Answer> countAnswer(Answer a) throws SQLException;

//把某个问题的答案全部遍历出来
	public List<Answer> findAllAnswer(Answer a) throws SQLException;

//某个用户所有的提问
	public List<Question> findMyAllQuestion(Question q) throws SQLException;

//查出某个用户所有回答的个数
	public List<Answer> findAllMyAnswerNumber(Answer a) throws SQLException;

//查出所有用户回答的所有问题
	public List<Question> findAllMyAnswer(Answer a) throws SQLException;

//提问者采纳回答者的回答，回答者金币数量增加
	public void addMoney(Answer a);

//提问者获得了自己想要的答案，即提问者采纳回答者的回答，问题状态变成已解决
	public void changeState(Answer a);

/*管理员问答模块
 * 思路
 *   1审核提问，决定用户的提问是否能发表
 *                    遍历出待审核的提问
 *                           确认通过审核
 *                           对不合格的进行删除
 *   2对问题和回答中不合规的进行删除
 *                      遍历出所有问题
 *        	查看问题详情
 *                                       对不合规的提问以及这个提问下的所有回答进行删除
 *                                       对某个不合规的回答进行删除,以及每删除一个回答回答的个数减一
 *    
 *         
 * 
 * 
 * */	
//遍历出待审核的提问
	public List<Question> checkQuestion() throws SQLException;

//确认通过审核
	public void passQuestion(Question q);
	
//删除不合规提问,以及删除这个提问下的所有回答
	public void delectQuestion(Question q);
	public void delectAllAnawer(Question q);
//   对某个不合规的回答进行删除,以及每删除一个回答回答的个数减一(试了无数次，更改回答个数没有反应，没有调用更改个数的方法)
	public void delectAnswer(Answer a);
	public void SubAnswerNumber(Answer a);
}
