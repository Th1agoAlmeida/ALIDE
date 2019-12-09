
var currentQuestion = 0;
var score = 0;
const increment = 10;
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

	let paragrafo_resultado = document.createElement('p');
	paragrafo_resultado.innerHTML = `Resultado: ${score} / ${increment * questions.length} Pontos`;
	
	resultCont.appendChild(paragrafo_resultado);

	let paragrafo = document.createElement('P');

	if(respostasErradas.length > 0) {
		let fail = document.createTextNode("Você não foi muito bem em algumas questões, recomento que olhe essas fontes de ensino: ");
		paragrafo.appendChild(fail);
		resultCont.appendChild(paragrafo);
	}

	for (let i in respostasErradas){
		console.log(i);
		let parag = document.createElement('p');

		let a = document.createElement('a');
		let text = document.createTextNode(recomendacoes[respostasErradas[i]][0]);
		a.appendChild(text);

		a.title = recomendacoes[respostasErradas[i]][0];
		a.href = recomendacoes[respostasErradas[i]][1];

		parag.appendChild(a);

		resultCont.appendChild(parag);

	}

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
		score += increment;
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