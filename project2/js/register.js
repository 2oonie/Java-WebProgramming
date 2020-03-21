function formValidation() {
// Make quick references to our fields.
let firstName = document.getElementById('firstName');
let lastName = document.getElementById('lastName');
let firstAddress = document.getElementById('firstAddress');
let zipCode = document.getElementById('zipCode');
let states = document.getElementById('states');
let userName = document.getElementById('userName');
let email = document.getElementById('email');
let city = document.getElementById('city');
let phoneNumber = document.getElementById('phoneNumber');
let pswrd = document.getElementById('password');
let repeatPassword = document.getElementById('repeatPassword');
let Status = document.getElementById('Status');
let Gender = document.getElementById('Gender');
let birthDay = document.getElementById('birthDay');

/*let Gender = document.jquerySelector('input[name = "Gender":checked');



let returnValue = true;

if(Gender != null)
{
	alert(Gender.value);
}
else
{
	alert('Nothing checked');
}*/

/*if(radioSelection(Status, "Select your status.", 'p13'))
{
	returnValue = false;
}

if(radioSelection(Gender, "Select your gender.", 'p14'))
{
	returnValue = false;
}*/

if(radioSelection(birthDay, "Select your DoB.", 'p15'))
{
	returnValue = false;
}



document.getElementById('p10').innerText = "✓";

if(pswrd != repeatPassword)
{
	document.getElementById('p10').innerText = "Password does not match.";
	returnValue = false;
}
if (!checkPassword(pswrd))
{
	returnValue = false;
}

if(lengthDefine(userName, 6, 50))
{
	returnValue = false;
}	
if(inputAlphabet(firstName, "* For your name please use alphabets only *", "p1"))
{
	returnValue = false;
}	

if(inputAlphabet(lastName, "* For your name please use alphabets only *", "p8"))
{
	returnValue = false;
}	

if(inputAlphabet(city, "* For your city please use alphabets only *", "p7"))
{
	returnValue = false;
}	

if(emailValidation(email, "* Please enter a valid email address *"))
{
	returnValue = false;
}	

if(trueSelection(states, "* Please Choose A State"))
{
	returnValue = false;
}	

if(textAlphanumeric(firstAddress, "* For Address please use numbers and letters *")) 
{	
	returnValue = false;
}	

if(textNumeric(phoneNumber, "* Please enter a valid phone number *", 'p11' ))
{
	returnValue = false;
}	

if(textNumeric(zipCode, "* Please enter a valid zip code *", 'p6'))
{
	returnValue = false;
}	

return returnValue;
}

// Function that checks whether input text is numeric or not.
function textNumeric(inputtext, alertMsg, ptag) {
let numericExpression = /^[0-9\-]+$/;
if (inputtext.value.match(numericExpression)) {
document.getElementById(ptag).innerText = "✓";
return true;
} 
document.getElementById(ptag).innerText = alertMsg; // This segment displays the validation rule for zip.
inputtext.focus();
return false;

}
// Function that checks whether input text is an alphabetic character or not.
function inputAlphabet(inputtext, alertMsg, ptag) {
let alphaExp = /^[a-zA-Z]+$/;
if (inputtext.value.match(alphaExp)) {
document.getElementById(ptag).innerText = "✓";
return true;
}
document.getElementById(ptag).innerText = alertMsg; // This segment displays the validation rule for name.
//alert(alertMsg);
inputtext.focus();
return false;

}
// Function that checks whether input text includes alphabetic and numeric characters.
function textAlphanumeric(inputtext, alertMsg) {
let alphaExp = /^[0-9a-zA-Z]+$/;
if (inputtext.value.match(alphaExp)) {
document.getElementById('p5').innerText = "✓";
return true;
}
document.getElementById('p5').innerText = alertMsg; // This segment displays the validation rule for address.
inputtext.focus();
return false;

}
// Function that checks whether the input characters are restricted according to defined by user.
function lengthDefine(inputtext, min, max) {
let uInput = inputtext.value;
if (uInput.length >= min && uInput.length <= max) {
document.getElementById('p2').innerText = "✓";
return true;
} 
document.getElementById('p2').innerText = "* Please enter between " + min + " and " + max + " characters *"; // This segment displays the validation rule for username
inputtext.focus();
return false;

}
// Function that checks whether a option is selected from the selector and if it's not it displays an alert message.
function trueSelection(inputtext, alertMsg) {
if (inputtext.value == "select") {
document.getElementById('p4').innerText = alertMsg; //this segment displays the validation rule for selection.
inputtext.focus();
return false;
}
document.getElementById('p4').innerText = "✓";
return true;

}


/*function radioSelection(inputtext, alertMsg, ptag) {
if (!inputtext.value == " ") {
document.getElementById(ptag).innerText = alertMsg; //this segment displays the validation rule for selection.
inputtext.focus();
return false;
}
document.getElementById(ptag).innerText = "✓";
return true;
}*/


// Function that checks whether an user entered valid email address or not and displays alert message on wrong email address format.
function emailValidation(inputtext, alertMsg) {
let emailExp = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

if (inputtext.value.match(emailExp)) {
document.getElementById('p3').innerText = "✓";
return true;
} 
document.getElementById('p3').innerText = alertMsg; // This segment displays the validation rule for email.
inputtext.focus();
return false;

}

function checkPassword(pswrd)
{
	
	pswrd = pswrd.value;
	let alertMsg = "✓";
	if(pswrd.length >= 50)
	{
		alertMsg = "Password is too long."
		
	}
	
	else if( pswrd.length <= 8)
	{
		alertMsg = "Password is too short."
	}
	else 
	{
		let counter = 0;
		if(pswrd.match(/\d+/))
		{
			counter++;
		}
		if(pswrd.match(/[A-Z]+/))
		{
			counter++;
		}
		if(pswrd.match(/[a-z]+/))
		{
			counter++;
		}
		if(pswrd.match(/[^a-zA-Z0-9]+/))
		{
			counter++;
		}
		console.log(counter);
		if(counter < 4)
		{
			alertMsg = "Password is missing an uppercase, lowercase, digit, or special character."
		}
	}
	
	document.getElementById('p9').innerText = alertMsg;
	
	return alertMsg == "✓";
}

$( document ).ready(function() {
$('#phoneNumber').keyup(function(){
		let ele = document.getElementById(this.id);
        if (ele.value == "")
		{
			return;
		}
		
		ele = ele.value.split('-').join('');    // Remove dash (-) if mistakenly entered.
		
		if (ele.lenght >= 10)
		{
			return;
		}
		else if (ele.length == 10)
		{
			$(this).val($(this).val().replace(/(\d{3})\-?(\d{3})\-?(\d{4})/,'$1-$2-$3'));
			
			return;
		}
		
        let finalVal = ele.match(/.{1,3}/g).join('-');
        document.getElementById(this.id).value = finalVal;
});

$('#zipCode').keyup(function(){

	let ele = document.getElementById(this.id);
	
	let zipCode = ele.value;
	
	zipCode = zipCode.split('-').join(''); 
	
	if(zipCode.length > 10)
	{	
		return;
	}
	if(zipCode.length > 5)
	{
		
		zipCode = String(zipCode);
		$(this).val(zipCode.substring(0,5) + "-" + zipCode.substring(5));
	}
});
//https://www.tutorialrepublic.com/codelab.php?topic=faq&file=jquery-get-selected-radio-button-value

//display if user input a good input for radio or display that they didnt pick
$("input[type='sumbit']").click(function(){
        	var radioValue = $("input[name='Gender']:checked").val();
            if(radioValue){
                alertMsg = "✓";
            }
			else{
				alertMsg = "Please pick a gender.";
				{
        });
		
$("input[type='sumbit']").click(function(){
        	var radioValue = $("input[name='Status']:checked").val();
            if(radioValue){
                alertMsg = "✓";
            }
			else{
				alertMsg = "Please pick a status.";
				{
        });
		
});

