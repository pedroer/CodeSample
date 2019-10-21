package com.example.Enum;

public enum Category {
	A("Arts, Culture and Humanities"), B("Educational Institutions and Related Activities"),
	C("Environmental Quality, Protection and Beautification"), D("Animal-Related"),
	E("Health - General and Rehabilitative"), F("Mental Health, Crisis Intervention"),
	G("Diseases, Disorders, Medical Disciplines"), H("Medical Research"), I("Crime, Legal-Related"),
	J("Employment, Job-Related"), K("Food, Agriculture and Nutrition"), L("Housing, Shelter"),
	M("Public Safety, Disaster Preparedness and Relief"), N("Recreation, Sports, Leisure, Athletics"),
	O("Youth Development"), P("Human Services - Multipurpose and Other"),
	Q("International, Foreign Affairs and National Security"), R("Civil Rights, Social Action, Advocacy"),
	S("Community Improvement, Capacity Building"), T("Philanthropy, Voluntarism and Grantmaking Foundations"),
	U("Science and Technology Research Institutes, Services"), V("Social Science Research Institutes, Services"),
	W("Public, Society Benefit - Multipurpose and Other"), X("Religion-Related, Spiritual Development"),
	Y("Mutual/Membership Benefit Organizations, Other"), Z("Unknown");

	private String category;

	Category(String category) {
		this.setCategory(category);
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}