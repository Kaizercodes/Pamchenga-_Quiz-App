package com.pamchenga.quizapp;

import java.util.*;
public class Question {
    // for encapsulation(hiding data)
    private String question;
    private ArrayList<String>options;
    private int answer;

    //constructor
    Question(String question, ArrayList<String>options, int answer){
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    //display question + options
    public void display(){
        System.out.println("\n" + question);

        for(int i = 0; i < options.size(); i++){
            System.out.println((i + 1) + " . " + options.get(i));      //print options
        }

    }

    //CHECK IF USER INPUT IS THE SAME AS REAL ANSWER
    boolean Check(int useranswer){
        return useranswer == answer ;
    }

    // Getter for the correct answer text
    public String getCorrectAnswer() {
        return options.get(answer);
    }

    // Getter for the question text
    public String getQuestion() {
        return question;
    }

    // Getter for the options
    public ArrayList<String> getOptions() {
        return options;
    }
}

//QUIZ CLASS TO MANAGE QUIZ QUESTIONS,  LOGIC AND KEEP SCORES

 class Quiz{
    private ArrayList<Question>questions;   //hold questions
    private int score;

    public Quiz(){
        questions = new ArrayList<>();  //to keep questions
        score = 0;
        loadQuestions();          //Calling the method

    }

    // A METHOD TO ADD SAMPLE QUESTIONS AND ANSWERS
    public void loadQuestions(){
        ArrayList<String> q1 = new ArrayList<>(Arrays.asList("Pacific","Atlantic", "Indian", "Arctic"));     //array list with the answers to the questions
        questions.add(new Question("What is the biggest Ocean on earth?", q1,0)); //addind questions in the arraylist

        ArrayList<String> q2= new ArrayList<>(Arrays.asList("India", "China", "America", "Russia"));
        questions.add(new Question("What country has the most population", q2,1));

        ArrayList<String> q3 = new ArrayList<>(Arrays.asList("North America", "Africa", "Asia", "Europe"));
        questions.add(new Question("Which continent has the most countries?", q3,1));

        ArrayList<String> q4 = new ArrayList<>(Arrays.asList("Mount Kilimanjaro","Mount Everest", "Mount Makalu", "Mount Rushmore"));
        questions.add(new Question("What is the tallest mountain in the world?", q4,1));

        ArrayList<String> q5 = new ArrayList<>(Arrays.asList("Nigeria","England", "Saudi Arabia", "Egypt"));
        questions.add(new Question("Where were the pyramids built?", q5,3));

        ArrayList<String> q6 = new ArrayList<>(Arrays.asList("South Africa","France", "America", "India"));
        questions.add(new Question("What country has the most time zones?", q6,1));

        ArrayList<String> q7 = new ArrayList<>(Arrays.asList("Hydro","Electricity", "Gravity", "Magnetism"));
        questions.add(new Question("What is the force that keeps planets in orbit?", q7,2));

        ArrayList<String> q8 = new ArrayList<>(Arrays.asList("Au","Hg", "Fe", "Go"));
        questions.add(new Question("What is the chemical symbol for gold", q8,0));

        ArrayList<String> q9 = new ArrayList<>(Arrays.asList("Sublimation", "Condensation", "Evaporation", "Melting"));
        questions.add(new Question("What is the process by which a liquid changes to a gas", q9,2));

        ArrayList<String> q10 = new ArrayList<>(Arrays.asList("1,080,000km/s", "299,792 km/s", "150,000 km/s", "30,000 km/s"));
        questions.add(new Question("What is the speed of light?", q10,1));

        ArrayList<String> q11 = new ArrayList<>(Arrays.asList("118","120", "115", "110"));
        questions.add(new Question("How many elements are in the periodic table?", q11,0));

        ArrayList<String> q12 = new ArrayList<>(Arrays.asList("Pluto","Jupiter", "Neptune", "Uranus"));
        questions.add(new Question("Which planet has the most moons", q12,1));

        ArrayList<String> q13 = new ArrayList<>(Arrays.asList("chest","arms", "jaw", "legs"));
        questions.add(new Question("Where is the strongest muscle located in the human body?", q13,2));

        ArrayList<String> q14 = new ArrayList<>(Arrays.asList("Two","none", "Four", "Three"));
        questions.add(new Question("How many bones do we have in an ear?", q14,3));

        ArrayList<String> q15 = new ArrayList<>(Arrays.asList("Medula Oblongata","Cerebellum", "Hippocampus", "Hypothalamus"));
        questions.add(new Question("What is the part of the brain responsible for learning?", q15,2));

        ArrayList<String> q16 = new ArrayList<>(Arrays.asList("Kneecap","Spread", "Paella", "Shoulder blade"));
        questions.add(new Question("By what name is the patella called?", q16,0));

        ArrayList<String> q17 = new ArrayList<>(Arrays.asList("Three","One", "Six", "Four"));
        questions.add(new Question("How many chambers does the human heart have?", q17,3));

        ArrayList<String> q18 = new ArrayList<>(Arrays.asList("Examining the mouth","Looking into the ear", "Checking Blood pressure", "Performing endoscopy"));
        questions.add(new Question("What is an otoscope used for?", q18,1));

        ArrayList<String> q19 = new ArrayList<>(Arrays.asList("Spain","Morroco", "Brazil", "Argentina"));
        questions.add(new Question("What is country won the 2022 FIFA World Cup?", q19,3));

        ArrayList<String> q20 = new ArrayList<>(Arrays.asList("Cheerleader","Referee", "Coach", "supporter"));
        questions.add(new Question("What do you call a person who blows the whistle in a game?", q20,1));

        ArrayList<String> q21 = new ArrayList<>(Arrays.asList("Three","Six", "Five", "Eight"));
        questions.add(new Question("How many rings are there on the Olympic flag?", q21,2));

        ArrayList<String> q22 = new ArrayList<>(Arrays.asList("Nine","Five", "Four", "Seven"));
        questions.add(new Question("How many athletes make up a netball team?", q22,3));

        ArrayList<String> q23 = new ArrayList<>(Arrays.asList("Football","Hockey", "Racing", "Basketball"));
        questions.add(new Question("Which sport is known as the king of sports?", q23,0));

        ArrayList<String> q24 = new ArrayList<>(Arrays.asList("Australia","England", "India", "South Africa"));
        questions.add(new Question("What country invented Cricket?", q24,1));

        ArrayList<String> q25 = new ArrayList<>(Arrays.asList("111111","312211", "121121", "222222"));
        questions.add(new Question("What is next in the sequence 1, 11, 21, 1211, 111221 ....?", q25,1));

        ArrayList<String> q26 = new ArrayList<>(Arrays.asList("Ocean","State", "Country", "animal"));
        questions.add(new Question("If you rearrange the letters LNGEDNA you have the name of a(n) :" , q26,2));

        ArrayList<String> q27 = new ArrayList<>(Arrays.asList("Three","Four and a half", "Four", "Five"));
        questions.add(new Question("John needs 13 bottles of water from the store. John can only carry 3 at a time. What is the minimum number of trips John needs to make to the store?" , q27,3));

        ArrayList<String> q28 = new ArrayList<>(Arrays.asList("1600","50", "163", "124"));
        questions.add(new Question("Bernado likes 25 but not 24; he likes 400 but not 300; he likes 144 but not 145.Which number does he like" , q28,0));

        ArrayList<String> q29 = new ArrayList<>(Arrays.asList("52462","51462", "12654", "25641"));
        questions.add(new Question("Which of the five choices makes the best comparison? PEACH is to HCAEP as 46251 is to:" , q29,2));

        ArrayList<String> q30 = new ArrayList<>(Arrays.asList("Painting","Novel", "Flower", "Poem"));
        questions.add(new Question("Which one of the following things is least like the others?" , q30,2));

        ArrayList<String> q31 = new ArrayList<>(Arrays.asList("John Steinbeck","William Shakespeare", "Charles Dickens", "Victor Hugo"));
        questions.add(new Question("Who wrote Romeo and Juliet?" , q31,1));

        ArrayList<String> q32 = new ArrayList<>(Arrays.asList("45","30", "90", "120"));
        questions.add(new Question("How many degrees are in a right angle?" , q32,2));

        ArrayList<String> q33 = new ArrayList<>(Arrays.asList("Rupee","Yen", "Euro", "Dollar"));
        questions.add(new Question("What is the currency of Japan?" , q33,1));

        ArrayList<String> q34 = new ArrayList<>(Arrays.asList("Nucleus","Cytoplasm", "Ribosomes", "Plasma Membrane"));
        questions.add(new Question("What part of the cell contains DNA?" , q34,0));

        ArrayList<String> q35 = new ArrayList<>(Arrays.asList("Brass","Titanium", "Copper", "Iron"));
        questions.add(new Question("Which metal has the chemical symbol Fe?" , q35,3));

        ArrayList<String> q36 = new ArrayList<>(Arrays.asList("Astronomy","Geography", "Organismology", " Biology"));
        questions.add(new Question("What is the study of living organisms called?" , q36,3));

        ArrayList<String> q37 = new ArrayList<>(Arrays.asList("Cheetah","Ostrich", "Lion", "Springbok"));
        questions.add(new Question("What is the fastest land animal?" , q37,0));

        ArrayList<String> q38 = new ArrayList<>(Arrays.asList("Green","Yellow", "Grey", "Pink"));
        questions.add(new Question("What color do you get when you mix red and white?" , q38,3));

        ArrayList<String> q39 = new ArrayList<>(Arrays.asList("Five","Seven", "Nine", "Six"));
        questions.add(new Question("How many continents are there on earth?" , q39,1));

        ArrayList<String> q40 = new ArrayList<>(Arrays.asList("Antarctic","Kalahari", "Gobi", "Sahara"));
        questions.add(new Question("What is the largest desert in the world?" , q40,0));

        ArrayList<String> q41 = new ArrayList<>(Arrays.asList("Triangulum","Messier", "Centaurus", "Milkyway"));
        questions.add(new Question("What is the name of the galaxy we live in?" , q41,3));

        ArrayList<String> q42 = new ArrayList<>(Arrays.asList("Methane","Nitrous oxide", "Carbon Dioxide", "Ozone"));
        questions.add(new Question("What is the main gas responsible for global warming?" , q42, 2));

        ArrayList<String> q43 = new ArrayList<>(Arrays.asList("Brain","Pancreas", "Heart", "Liver"));
        questions.add(new Question("Which organ in the human body? produces insulin?" , q43,1));

        ArrayList<String> q44 = new ArrayList<>(Arrays.asList("Dinucleic Acid","Deoxyribonucleic Acid", "Dioxribonitric Acid", "Deoxyribogenetic Acid"));
        questions.add(new Question("What does DNA stand for?" , q44,1));

        ArrayList<String> q45 = new ArrayList<>(Arrays.asList("Piano","Guitar", "Xylophone", "Guitar"));
        questions.add(new Question("Which musical instrument has black and white keys?" , q45,0));

        ArrayList<String> q46 = new ArrayList<>(Arrays.asList("Tree","Twig", "Branch", "Bark"));
        questions.add(new Question("Which of the four choices makes the best comparison?  Finger is to hand as leaf is" , q46,1));

        ArrayList<String> q47 = new ArrayList<>(Arrays.asList("Malaysia","Bangladesh", "Thailand", "China"));
        questions.add(new Question("Which country is famous for the Great Wall?" , q47,3));

        ArrayList<String> q48 = new ArrayList<>(Arrays.asList("Mandarin","English", "Hindi", "Chinese"));
        questions.add(new Question("What is the most spoken language in the world?" , q48,0));

        ArrayList<String> q49 = new ArrayList<>(Arrays.asList("Christopher Columbus","Ferdinand Magellan", "Vasco Da Gamma", "Dr David Livingstone"));
        questions.add(new Question("Who was the first person to circumnavigate the globe?" , q49,1));

        ArrayList<String> q50 = new ArrayList<>(Arrays.asList("lobotomy","Earlobe", "blockhead", "Wheelbarrow"));
        questions.add(new Question("The word 'elbow' can be spelled using only the letters found in which of the following words?" , q50,3));

        ArrayList<String> q51 = new ArrayList<>(Arrays.asList("Resolute","Reliable", "Relevant", "Insolent"));
        questions.add(new Question("Choose the word similar to 'Trustworthy' :" , q51,1));

        ArrayList<String> q52 = new ArrayList<>(Arrays.asList("25","10", "5", "50"));
        questions.add(new Question("Choose the number that is 1/4 of 1/2 of 1/5 of 200:" , q52,2));

        ArrayList<String> q53 = new ArrayList<>(Arrays.asList("Quartz","Iron", "Gold", "Diamond"));
        questions.add(new Question("What is the hardest natural substance on earth?" , q53,3));

        ArrayList<String> q54 = new ArrayList<>(Arrays.asList("Steve Jobs","Charles Babbage", "Bill Gates", "Alan Turing"));
        questions.add(new Question("Who is known as the Father of Computers?" , q54,1));

        ArrayList<String> q55 = new ArrayList<>(Arrays.asList("Rio de Janeiro","Santos", "Moscow", "Salvador"));
        questions.add(new Question("What is the capital of Brazil?" , q55,0));

        ArrayList<String> q56 = new ArrayList<>(Arrays.asList("Misspelled","Incorrectly", "Wrongly", "Error"));
        questions.add(new Question("What word is spelled incorrectly in every dictionary?" , q56,1));

        ArrayList<String> q57 = new ArrayList<>(Arrays.asList("Keyboard","Code", "Map", "Piano"));
        questions.add(new Question("What has keys but cannot open locks?" , q57,3));

        ArrayList<String> q58 = new ArrayList<>(Arrays.asList("A fish","A ball", "A cold", "A frisbee"));
        questions.add(new Question("What can you catch but not throw?" , q58,2));

        ArrayList<String> q59 = new ArrayList<>(Arrays.asList("Coin","Comet", "Snake", "Kite"));
        questions.add(new Question("What has a head, a tail but no body?" , q59,0));

        ArrayList<String> q60 = new ArrayList<>(Arrays.asList("Glass","Metal", "Wood", "Promise"));
        questions.add(new Question("What can you break, even if you can never pick it up or touch it?" , q60,3));

        ArrayList<String> q61 = new ArrayList<>(Arrays.asList("Wood","Match", "Oil Lamp", "Newspaper"));
        questions.add(new Question("If you have one match and enter a dark room containing an oil lamp, some wood and a newspaper, what do you light first?" , q61,1));

        ArrayList<String> q62 = new ArrayList<>(Arrays.asList("Map","Compass", "Stamp", "Satellite"));
        questions.add(new Question("What can travel around the world while staying in the same corner?" , q62,2));

        ArrayList<String> q63 = new ArrayList<>(Arrays.asList("Teapot","Tent", "Ticket", "Tint"));
        questions.add(new Question("What begins with T, ends with T, and has T in it?" , q63,0));

        ArrayList<String> q64 = new ArrayList<>(Arrays.asList("A handful","Nine", "Gang", "Crew"));
        questions.add(new Question("If two is company and three is a crowd what is four and five?" , q64,1));

        ArrayList<String> q65 = new ArrayList<>(Arrays.asList("The moon","A leaf", "The sun", "The letter 'e'"));
        questions.add(new Question("You see me once in June, twice in November but never in May. What am I?" , q65,3));

        ArrayList<String> q66 = new ArrayList<>(Arrays.asList("A ghost","Your Thoughts", "The air", "The Future"));
        questions.add(new Question("What is always in front of you but can't be seen?" , q66,3));

        ArrayList<String> q67 = new ArrayList<>(Arrays.asList("Silence","A wish", "Time", "A dream"));
        questions.add(new Question("What disappears as soon as you mention its name?" , q67,0));

        ArrayList<String> q68 = new ArrayList<>(Arrays.asList("Neither","Both", "The yolk of the egg is white", "The yolk of the egg are white"));
        questions.add(new Question("Which is  correct: 'The yolk of the egg is white' or 'The yolk of the egg are white'" , q68,0));

        ArrayList<String> q69 = new ArrayList<>(Arrays.asList("A clock","A river", "A car", "A piece of land"));
        questions.add(new Question("What runs but never walks, has a bed but never sleeps, has a mouth but never eats?" , q69,1));

        ArrayList<String> q70 = new ArrayList<>(Arrays.asList("Temperature","Rain", "Age", "Time"));
        questions.add(new Question("What comes up but never goes up?" , q70,2));

        ArrayList<String> q71 = new ArrayList<>(Arrays.asList("Yellow","Wet", "Invincible", "Red"));
        questions.add(new Question("If you drop yellow hat in the Red Sea, what does it become?" , q71,1));

        ArrayList<String> q72 = new ArrayList<>(Arrays.asList("Twelve","Six", "Eight", "Seven"));
        questions.add(new Question("How many months have 31 days?" , q72,3));

        ArrayList<String> q73 = new ArrayList<>(Arrays.asList("Small","Short", "Fast", "Tall"));
        questions.add(new Question("What word becomes shorter when you add two more letters to it" , q73,1));

        ArrayList<String> q74 = new ArrayList<>(Arrays.asList("Heat","Dust", "Air", "Light"));
        questions.add(new Question("What can fill up an entire room but takes up no space?" , q74,3));

        ArrayList<String> q75 = new ArrayList<>(Arrays.asList("Giraffe","Orca", "Blue Whale", "Elephant"));
        questions.add(new Question("What is the largest mammal in the world?" , q75,2));

        ArrayList<String> q76 = new ArrayList<>(Arrays.asList("Eight","Twelve", "Six", "Ten"));
        questions.add(new Question("How many legs does a spider have?" , q76,0));

        ArrayList<String> q77 = new ArrayList<>(Arrays.asList("Eight","Four", "Five", "Three"));
        questions.add(new Question("What number is spelled with the same number of letters as its value?" , q77,1));

        ArrayList<String> q78 = new ArrayList<>(Arrays.asList("Antarctica","Africa", "America", "Asia"));
        questions.add(new Question("Which continent is the driest?" , q78,0));

        ArrayList<String> q79 = new ArrayList<>(Arrays.asList("Stem","Roots", "Flowers", "Leaves"));
        questions.add(new Question("Which part of the plant conducts photosynthesis?" , q79,3));

        ArrayList<String> q80 = new ArrayList<>(Arrays.asList("Universal System Backup","Universal Serial Bus", "Universal System Board", "Universal System Band"));
        questions.add(new Question("What does 'USB' stand for?" , q80,1));

        ArrayList<String> q81 = new ArrayList<>(Arrays.asList("Artificial Intelligence","Automated Interface", "Analogue Input", "Advanced Integration"));
        questions.add(new Question("What does AI stand for?" , q81,0));

        ArrayList<String> q82 = new ArrayList<>(Arrays.asList("Four","Nine", "Seven", "Six"));
        questions.add(new Question("How many colors are in a rainbow ?" , q82,2));

        ArrayList<String> q83 = new ArrayList<>(Arrays.asList("Vegetables","Honey", "Bread", "Meat"));
        questions.add(new Question("What is the only food that does not spoil?" , q83,1));

        ArrayList<String> q84 = new ArrayList<>(Arrays.asList("Meta","Google", "Apple", "Amazon"));
        questions.add(new Question("What parent company owns both Whatsapp and Instagram?" , q84,0));

        ArrayList<String> q85 = new ArrayList<>(Arrays.asList("Fine","Formation", "Function", "Fun"));
        questions.add(new Question("What is the meaning of 'fn' on a computer keyboard?" , q85,2));

        ArrayList<String> q86 = new ArrayList<>(Arrays.asList("ctrl w","ctrl c", "ctrl x", "ctrl z"));
        questions.add(new Question("What is the shortcut for the 'copy' function on most computers?" , q86,1));

        ArrayList<String> q87 = new ArrayList<>(Arrays.asList("Megabyte","Terabyte", "Gigabyte", "Kilobyte"));
        questions.add(new Question("What is often seen as the smallest unit of memory?" , q87,3));

        ArrayList<String> q88 = new ArrayList<>(Arrays.asList("Operating Systems","High level programming languages", "Browsers", "Computer Brands"));
        questions.add(new Question("Firefox, Google Chrome, Microsoft Explorer and Brave are common types of what?" , q88,2));

        ArrayList<String> q89 = new ArrayList<>(Arrays.asList("31","21", "26", "8"));
        questions.add(new Question("What is the next number in the series: 1 - 1 - 2- 3 - 5 - 8 - 13?" , q89,1));

        ArrayList<String> q90 = new ArrayList<>(Arrays.asList("Controlling Protocol Unit","Central Processing Unit", "Computer Programming Unit", "Central Programming Unit"));
        questions.add(new Question("In computing, what does 'CPU' stand for?" , q90,1));

        ArrayList<String> q91 = new ArrayList<>(Arrays.asList("Maize","Millet", "Wheat", "Rice"));
        questions.add(new Question("What other name does 'corn' go by?" , q91,0));

        ArrayList<String> q92 = new ArrayList<>(Arrays.asList("Flock","School", "Pack", "Army"));
        questions.add(new Question("What name is given to a group of frogs?" , q92,3));

        ArrayList<String> q93 = new ArrayList<>(Arrays.asList("Microsoft","Amazon", "Google", "Meta"));
        questions.add(new Question("Bill Gates is the founder of which company?" , q93,0));

        ArrayList<String> q94 = new ArrayList<>(Arrays.asList("Cloth","Towel", "Rain", "Sponge"));
        questions.add(new Question("What gets wetter and wetter the more it dries?" , q94,1));

        ArrayList<String> q95 = new ArrayList<>(Arrays.asList("Two","Six", "Four", "None"));
        questions.add(new Question("If there are six apples and you take away four, how many do you have?" , q95,2));

        ArrayList<String> q96 = new ArrayList<>(Arrays.asList("Eating","Sleeping", "Laughing", "Crying"));
        questions.add(new Question("A person who has insomnia has difficulty doing what?" , q96,1));

        ArrayList<String> q97 = new ArrayList<>(Arrays.asList("Neither","Country", "Both", "State"));
        questions.add(new Question("Is Georgia a state or a country?" , q97,2));

        ArrayList<String> q98 = new ArrayList<>(Arrays.asList("Worm","Virus", "Spyware", "Trojan Horse"));
        questions.add(new Question("What kind of malware disguises itself as legitimate software before its true intent is discovered?" , q98,3));

        ArrayList<String> q99 = new ArrayList<>(Arrays.asList("Pride","School", "Colony", "Flock"));
        questions.add(new Question("What is a group of lions called?" , q99,0));

        ArrayList<String> q100 = new ArrayList<>(Arrays.asList("One","None", "Four", "Three"));
        questions.add(new Question("How many stripes does the Adidas brand have?" , q100,3));

        ArrayList<String> q101 = new ArrayList<>(Arrays.asList("0","2", "1", "3"));
        questions.add(new Question("What is the smallest prime number?" , q101,2));

        ArrayList<String> q102 = new ArrayList<>(Arrays.asList("Web World Wide","World Wide Web", "Wide Web World", "World Web Window"));
        questions.add(new Question("What does the 'www' stand for in a website browser?" , q102,1));

        ArrayList<String> q103 = new ArrayList<>(Arrays.asList("Koala","Elephant", "Cat", "Gorilla"));
        questions.add(new Question("Which animal is known to have fingerprints like humans?" , q103,3));

        ArrayList<String> q104 = new ArrayList<>(Arrays.asList("5","17", "14", "11"));
        questions.add(new Question("What is the odd one out?" , q104,2));

        ArrayList<String> q105 = new ArrayList<>(Arrays.asList("9","19", "6", "18"));
        questions.add(new Question("Which number comes next in the sequence 4,6,9,6,14,?" , q105,1));

        ArrayList<String> q106 = new ArrayList<>(Arrays.asList("1:00","3:00", "7:00", "11:00"));
        questions.add(new Question("If a clock shows 3:00 now, what time will it show after a 100 hours" , q106,1));

        ArrayList<String> q107 = new ArrayList<>(Arrays.asList("DKTF","FJHL", "CJSE", "DKTF"));
        questions.add(new Question("If 'FISH' is coded as 'IJTI', what is the code for 'BIRD'" , q107,2));

        ArrayList<String> q108 = new ArrayList<>(Arrays.asList("6","10", "4", "8"));
        questions.add(new Question("What is the only number that is both the sum and product of the same positive integers" , q108,2));

        ArrayList<String> q109 = new ArrayList<>(Arrays.asList("194","250", "385", "370"));
        questions.add(new Question("I am a three-digit number. My tens digit is five more than my ones digit, and my hundreds digit is eight less than my tens digit. What am I?" , q109,0));

        ArrayList<String> q110 = new ArrayList<>(Arrays.asList("20","5", "25", "10"));
        questions.add(new Question("If 5 cats can catch 5 mice in 5 minutes, how many cats are needed to catch 100 mice in 100 minutes?" , q110,1));

        ArrayList<String> q111 = new ArrayList<>(Arrays.asList("1","Infinity", "0", "10"));
        questions.add(new Question("If you multiply me by any other number, the result will always remain the same. What number am I?" , q111,2));

        ArrayList<String> q112 = new ArrayList<>(Arrays.asList("9","8", "0", "17"));
        questions.add(new Question("A farmer has 17 sheep, and all but 9 die. How many are left?" , q112,0));

        ArrayList<String> q113 = new ArrayList<>(Arrays.asList("India","Russia", "Greece", "Egypt"));
        questions.add(new Question("Which country is both in Europe and Asia?" , q113,1));

        ArrayList<String> q114 = new ArrayList<>(Arrays.asList("A","B", "O", "AB"));
        questions.add(new Question("Which blood type is known as the “universal donor”?" , q114,2));

        ArrayList<String> q115 = new ArrayList<>(Arrays.asList("Word","Nibble", "Byte", "Bit"));
        questions.add(new Question("What is the smallest unit of data in computing?" , q115,3));

        ArrayList<String> q116 = new ArrayList<>(Arrays.asList("Footsteps","Memories", "Time", "Knowledge"));
        questions.add(new Question("The more you take, the more you leave behind. What am I?" , q116,0));

        ArrayList<String> q117 = new ArrayList<>(Arrays.asList("Mountain","Tree", "Candle", "Pen"));
        questions.add(new Question("I’m tall when I’m young and short when I’m old. What am I?" , q117,2));

        ArrayList<String> q118 = new ArrayList<>(Arrays.asList("Quite","Quiet", "Queen", "Queue"));
        questions.add(new Question("Which English word retains the same pronunciation even after you remove four of its five letters?" , q118,3));

        ArrayList<String> q119 = new ArrayList<>(Arrays.asList("4","2", "6", "None"));
        questions.add(new Question("If there are 6 apples and you take away 4, how many do you have?" , q119,0));

        ArrayList<String> q120 = new ArrayList<>(Arrays.asList("Knowledge","Money", "Love", "Secret"));
        questions.add(new Question("The more you share me, the less I become. What am I?" , q120,3));

        ArrayList<String> q121 = new ArrayList<>(Arrays.asList("999999","0", "1", "362880"));
        questions.add(new Question("Which number do you get when you multiply all the numbers on a phone’s dial pad?" , q121,1));

        ArrayList<String> q122 = new ArrayList<>(Arrays.asList("10","19", "20", "21"));
        questions.add(new Question("If you write all the numbers from 1 to 100, how many times do you write the digit “7”?" , q122,2));

        ArrayList<String> q123 = new ArrayList<>(Arrays.asList("72","63", "54", "81"));
        questions.add(new Question("I am a two-digit number. The sum of my digits is 9, and their difference is 3. What number am I?" , q123,1));

        ArrayList<String> q124 = new ArrayList<>(Arrays.asList("70","12", "50", "90"));
        questions.add(new Question("Divide 30 by 1/2 and add 10. What’s the result?" , q124,0));

        ArrayList<String> q125 = new ArrayList<>(Arrays.asList("Letter 'D'","Letter 'O'", "Letter 'N'", "Letter 'E'"));
        questions.add(new Question("If you throw me out a window, you’ll leave a grieving wife. But put me in a door, and I’ll give someone a new life. What am I?" , q125,2));

        ArrayList<String> q126 = new ArrayList<>(Arrays.asList("Stone","Fire", "Plant", "Cloud"));
        questions.add(new Question("I’m not alive, but I grow. I don’t have lungs, but I need air. I don’t have a mouth, but water kills me. What am I?" , q126,1));

    }
    public void start(){
        Scanner input = new Scanner(System.in);

        Collections.shuffle(questions);   //making the questions to be random with each new run

        int numberToask = 10;

        List<Question>quizQuestions = questions.subList(0, numberToask); //selecting a particular number of questions to be shown

        for(Question q :quizQuestions){
            q.display(); //display the questions

            System.out.print("Enter your answer: ");
            int ans = input.nextInt();


            if(q.Check(ans - 1 )){
                System.out.println("You got it correct!");
                    score++;

            }

            else{
                System.out.println("Wrong answer. The correct answer: " +  q.getCorrectAnswer());
            }
        }
         displayResults();
    }

    private void displayResults() {
        System.out.println("\ncom.pamchenga.quizapp.Quiz Over!");
        System.out.println("Your score: " + score + "/" + "10 ." + "Try again sometime. Learning never stops");
    }


     public List<Question> getQuestion(int n) {
         Collections.shuffle(questions);          // shuffle all questions
         if (n > questions.size()) n = questions.size(); // avoid out-of-bounds
         return new ArrayList<>(questions.subList(0, n)); // return n questions

    }

 }

