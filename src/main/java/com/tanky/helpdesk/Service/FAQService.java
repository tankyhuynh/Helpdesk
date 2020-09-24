package com.tanky.helpdesk.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanky.helpdesk.Entity.FAQEntity;
import com.tanky.helpdesk.Entity.StatusEntity;
import com.tanky.helpdesk.Repository.FAQRepo;

@Service
public class FAQService {

	@Autowired
	private FAQRepo faqRepo;
	
	
	public List<FAQEntity> findAll() {
		return faqRepo.findAll();
	}
	
	public FAQEntity findOne(Long id) {
		return faqRepo.findById(id).orElse(new FAQEntity());
	}
	
	public FAQEntity save(FAQEntity entity) {
		return faqRepo.save(entity);
	}
	
	public void saveAll(List<FAQEntity> faqs) {
		for (FAQEntity faq : faqs) {
			faqRepo.save(faq);
		}

	}
	
	public void delete(Long id) {
		faqRepo.deleteById(id);
	}
	
	
	
}
