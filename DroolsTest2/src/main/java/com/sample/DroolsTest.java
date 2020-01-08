package com.sample;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
    	//ask questions
    	askQuestions();
    	
    	//fire all rules
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
        	ArrayList<Recipe> recipes = init();
            kSession.insert(recipes);
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        
        //results
    }
    
    public static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static void askQuestions(){
    	//make question list
    	ArrayList<Question> questions = new ArrayList<Question>();
    	Question q;
    	//make questions
    	q = new Question();
    	q.setQuestion("Wat is je favoriete keuken?");
    	q.addAnswer("Hollandse pot");
    	q.addAnswer("Italiaanse keuken");
    	q.addAnswer("Spaanse keuken");
    	q.addAnswer("Mexicaanse keuken");
    	q.addAnswer("Indiase keuken");
    	q.addAnswer("Indonesische keuken");
    	q.addAnswer("Thaise keuken");
    	q.addAnswer("Geen voorkeur");
    	questions.add(q);
    	
    	q = new Question();
    	q.setQuestion("Hou je van pittig eten?");
    	q.addAnswer("Ik kan totaal niet tegen pittig eten");
    	q.addAnswer("Ik hou van gematigd pittig eten");
    	q.addAnswer("Ik kan goed tegen pittig eten");
    	questions.add(q);
    	
    	q = new Question();
    	q.setQuestion("Ben je bereid om nieuwe dingen te proberen?");
    	q.addAnswer("Ja");
    	q.addAnswer("Nee");
    	questions.add(q);
    	
    	q = new Question();
    	q.setQuestion("Wat is je favoriete groente?");
    	q.addAnswer("Wortel");
    	q.addAnswer("Tomaat");
    	q.addAnswer("Paprika");
    	q.addAnswer("Kool");
    	q.addAnswer("Bladgroenten");
    	q.addAnswer("Bonen");
    	q.addAnswer("Broccoli");
    	q.addAnswer("Spinazie");
    	q.addAnswer("Sla");
    	q.addAnswer("Ik eet geen groenten");
    	q.addAnswer("Ik hou van alle groenten");
    	questions.add(q);
    	
    	//Optionele vraag: Vraag niet stellen als antwoord vorige vraag = ‘Ik hou van alle groenten’
    	//Welke groente lust je niet? (Repeaten totdat ‘Ik lust alle bovenstaande groenten’)
    	
    	q = new Question();
    	q.setQuestion("Welke groente lust je niet?");
    	q.addAnswer("Wortel");
    	q.addAnswer("Tomaat");
    	q.addAnswer("Paprika");
    	q.addAnswer("Kool");
    	q.addAnswer("Bladgroenten");
    	q.addAnswer("Bonen");
    	q.addAnswer("Broccoli");
    	q.addAnswer("Spinazie");
    	q.addAnswer("Sla");
    	q.addAnswer("Ik heb alle groenten aangegeven die ik niet lust.");
    	questions.add(q);
    	
    	q = new Question();
    	q.setQuestion("Hou je van fruit in avondmaaltijden?");
    	q.addAnswer("Ja");
    	q.addAnswer("Nee");
    	q.addAnswer("Geen voorkeur");
    	questions.add(q);
    	
    	//Optionele vraag Vraag alleen stellen als antwoord op vorige vraag = ‘ja’ of ‘geen voorkeur’
    	//OF 
    	//Antwoord op vorige vraag = ‘nee’ && je wilt nieuwe dingen proberen
    	
    	q = new Question();
        q.setQuestion("Wat is je favoriete fruit?");
        q.addAnswer("Appel");
        q.addAnswer("Aardbei");
        q.addAnswer("Ananas");
        q.addAnswer("Banaan");
        q.addAnswer("Bessen");
        q.addAnswer("Kiwi");
        q.addAnswer("Mango");
        q.addAnswer("Sinaasappel");
        q.addAnswer("Perzik");
        q.addAnswer("Ik houd van al het fruit");
        questions.add(q);
    	
    	q = new Question();
    	q.setQuestion("Waar ga je boodschappen doen?");
    	q.addAnswer("Grote Supermarkt");
    	q.addAnswer("Kleine lokale supermakrt");
    	q.addAnswer("De markt");
    	questions.add(q);
    	
    	q = new Question();
    	q.setQuestion("Heb je een oven?");
    	q.addAnswer("Ja");
    	q.addAnswer("Nee");
    	questions.add(q);
    	
    	q = new Question();
    	q.setQuestion("Gaat je voorkeur uit naar kip, varken, rundvlees, vis, vegetarisch, of heb je geen voorkeur?");
    	q.addAnswer("Kip");
    	q.addAnswer("Varkensvlees");
    	q.addAnswer("Rundvlees");
    	q.addAnswer("Vis");
    	q.addAnswer("Vegetarisch");
    	q.addAnswer("Geen voorkeur");
    	questions.add(q);
    	
    	//Optionele vraag Wanneer antwoord = vegetarisch
    	
    	q = new Question();
    	q.setQuestion("Wil je vleesvervangers gebruiken of gaat je voorkeur uit naar een origineel vegetarisch gerecht?");
    	q.addAnswer("Origineel vegetarisch gerecht");
    	q.addAnswer("Vleesvervangers");
    	q.addAnswer("Geen voorkeur");
    	questions.add(q);
    	
    	q = new Question();
    	q.setQuestion("Wil je warm of koud eten? ");
    	q.addAnswer("Warm");
    	q.addAnswer("Koud");
    	q.addAnswer("Geen voorkeur");
    	questions.add(q);
    	
    	q = new Question();
    	q.setQuestion("Hoeveel tijd wil je besteden aan het bereiden?");
    	q.addAnswer("0-30 minuten");
    	q.addAnswer("30-60 minuten");
    	q.addAnswer("Meer dan 60 minuten");
    	q.addAnswer("Geen voorkeur");
    	questions.add(q);
    	
    	q = new Question();
    	q.setQuestion("Ben je allergisch voor een van de onderstaande ingrediënten?");
    	q.addAnswer("Granen");
    	q.addAnswer("Vis en schaaldieren");
    	q.addAnswer("Eieren");
    	q.addAnswer("Pinda's");
    	q.addAnswer("Soya");
    	q.addAnswer("Melk");
    	q.addAnswer("Noten");
    	q.addAnswer("Mosterd");
    	q.addAnswer("Fruit");
    	q.addAnswer("Sesamzaad");
    	q.addAnswer("Ik ben niet allergisch voor een van de bovenstaande producten.");
    	questions.add(q);
    	
    	//ask questions
    	int k = 0;
    	Scanner scanner = new Scanner(System.in);
    	for(int i = 0;i < questions.size();i++){
    		//read question and possible answers
    		Question question = questions.get(i);
    		ArrayList<String> answers = question.getAnswers();
    		//print question
    		System.out.println(question.getQuestion());
    		//print answers
    		for(int j = 0;j < answers.size();j++){
    			System.out.println( (j+1) + ") " + answers.get(j) );
    		}
    		//scan chosen answer
    		int chosenAnswer = 0;
    		while(scanner.hasNext()){
    			String output = scanner.next();
    			if(isInteger(output)){
    				chosenAnswer = Integer.parseInt(output);
    				if(chosenAnswer > 0 && chosenAnswer <= answers.size()){
    					if (i == 3 && (chosenAnswer == 11 || chosenAnswer == 10)) {
    						i++;
    					}
    					if (i == 4 && chosenAnswer != 10) {
    						i--;
    					}
    					if (i == 5 && chosenAnswer == 2) {
    						i++;
        				}
    					if (i == 9 && chosenAnswer != 5) {
    						i++;
    					}
    					if (i == 13 && chosenAnswer != 11) {
    						i--;
    					}
    					break;
    				}
    			}
    		}
    		question.setChosenAnswer(chosenAnswer);
    	}
    	scanner.close();
    }
    
    public static class Question {
    	private String question;
    	private ArrayList<String> answers = new ArrayList<String>();
    	private int chosenAnswer;
    	
    	/*
    	 * Getters and setters
    	 */
    	public String getQuestion(){
    		return question;
    	}
    	
    	public void setQuestion(String question){
    		this.question = question;
    	}
    	
    	public ArrayList<String> getAnswers(){
    		return this.answers;
    	}
    	
    	public void addAnswer(String answer){
    		this.answers.add(answer);
    	}
    	
    	public int getChosenAnswer(){
    		return chosenAnswer;
    	}
    	
    	public void setChosenAnswer(int chosenAnswer){
    		this.chosenAnswer = chosenAnswer;
    	}
    }
    
    public static ArrayList<Recipe> init(){
    	ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    	//add recipes
    	
    	return recipes;
    }
    
    public static class Recipe {
        private String name;
        private int time;
    	private String cuisine;
    	private ArrayList<String> ingredients;
        
        public void setCuisine(String cuisine){
        	this.cuisine = cuisine;
        }

    }

}