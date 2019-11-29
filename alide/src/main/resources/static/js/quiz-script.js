
var currentQuestion = 0;
var score = 0;
var totQuestions = questions.length;
var respostasErradas = [];

var container = document.getElementById('quizContainer');
var question = document.getElementById('question');
var opt1 = document.getElementById('opt1');
var opt2 = document.getElementById('opt2');
var opt3 = document.getElementById('opt3');
var opt4 = document.getElementById('opt4');
var nextButton = document.getElementById('nextButton');
var resultCont = document.getElementById('result');

function resultadoFinal() {

	container.style.display = 'none';
	resultCont.style.display = 'block';

	// resultCont.textContent = 'Sua pontuação: ' + score;
	for (let i in respostasErradas){
		var parag = document.createElement('P');
		var text = document.createTextNode(recomendacoes[respostasErradas[i]]);
		parag.appendChild(text);
		resultCont.appendChild(parag);
	}
	let paragrafo_resultado = document.createElement('p');
	paragrafo_resultado.innerHTML = `Resultado: ${score} Pontos`;

	 resultCont.appendChild(paragrafo_resultado);
} 

function loadQuestion(index) {
	let q = questions[index];
	question.textContent = (index + 1) + '. ' + q.question;
	opt1.textContent = q.option1;
	opt2.textContent = q.option2;
	opt3.textContent = q.option3;
	opt4.textContent = q.option4;
};

function loadNextQuestion() {

	let selectedOption = document.querySelector('input[type=radio]:checked');

	if(!selectedOption){

		alert('Por favor, selecione uma alternativa!');

	}

	var answer = selectedOption.value;

	if(questions[currentQuestion].answer == answer){ // Se questão correta score recebe +10 pt senão numero da questão guarde para recber recomendação de estudo
		score += 10;
	} else {
		respostasErradas.push(currentQuestion);
	}
	
	currentQuestion++;
	selectedOption.checked = false;
	
	if(currentQuestion == totQuestions - 1){ // Verifica até ultima questão, quando chegar a ultima questão troca o nome do botão
		nextButton.textContent = 'Finish';
	}

	if(currentQuestion == totQuestions){
		resultadoFinal();
		return;
	}

	loadQuestion(currentQuestion);
}

loadQuestion(currentQuestion); // Load Inicial