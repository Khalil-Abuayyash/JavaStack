package com.khalil.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khalil.dojooverflow.models.Answer;
import com.khalil.dojooverflow.models.Question;
import com.khalil.dojooverflow.models.RegexQuestion;
import com.khalil.dojooverflow.models.Tag;
import com.khalil.dojooverflow.repositories.AnswerRepository;
import com.khalil.dojooverflow.repositories.QuestionRepository;
import com.khalil.dojooverflow.repositories.TagRepository;

@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;
	private final TagRepository tagRepository;
	
	public QuestionService(QuestionRepository questionRepository, AnswerRepository answerRepository, TagRepository tagRepository) {
		this.questionRepository = questionRepository;
		this.answerRepository = answerRepository;
		this.tagRepository = tagRepository;
	}
	
	public List<Question> allQuestions() {
		return questionRepository.findAll();
	}
	
	public List<Answer> allAnswers() {
		return answerRepository.findAll();
	}
	
	public List<Tag> allTags() {
		return tagRepository.findAll();
	}
	
	public Question findQuestionById(Long id) {
		Optional<Question> optionalQuestion = questionRepository.findById(id);
		if (optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		}
		return null;
	}
	
	public Question saveQuestion(Question question) {
		return questionRepository.save(question);
	}
	
	public Answer saveAnswer(Answer answer) {
		return answerRepository.save(answer);
	}
	
	public Answer addAnswer(Answer answer, Long id) {
		Answer an = new Answer();
		an.setAnswer(answer.getAnswer());
		Question question = this.findQuestionById(id);
		an.setQuestion(question);
		return answerRepository.save(an);
		
	}
	
	public void createQuestion(RegexQuestion question) {
		List<Tag> questionsTags = new ArrayList<Tag>();
		for(String subject: question.splitTags()) {
			Tag tag = this.tagRepository.findBySubject(subject).orElse(null);
			if(tag == null) {
				tag = new Tag(subject);
				this.tagRepository.save(tag);
			}
			
			if(!questionsTags.contains(tag))
				questionsTags.add(tag);
		}
		Question q = new Question(question.getQuestion(), questionsTags);
		this.questionRepository.save(q);
	}

}
