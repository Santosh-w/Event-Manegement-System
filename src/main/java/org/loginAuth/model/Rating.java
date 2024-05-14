package org.loginAuth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name =  "rating", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Rating {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "reviewer")
	private String reviewer;
	

	@Column(name = "review")
	private String review;
	
	@Column(name = "reviewee")
	private String reviewee;
	
	@Column(name = "review_Date")
	private String reviewDate;
	
	public Rating() {
	
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getReviewee() {
		return reviewee;
	}

	public void setReviewee(String reviewee) {
		this.reviewee = reviewee;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public Rating(String reviewer, String review, String reviewee, String reviewDate) {
		super();
		this.reviewer = reviewer;
		this.review = review;
		this.reviewee = reviewee;
		this.reviewDate = reviewDate;
	}


}
