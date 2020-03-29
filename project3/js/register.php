<?php
// define variables and set to empty values
$userNameErr = $passwordErr = $ repeatPasswordErr = $firstNameErr = $lastNameErr = $firstAddressErr 
$cityErr = $statesErr = $zipCodeErr = $phoneNumberErr = $emailErr = $GenderErr = $StatusErr = $birthDayErr = "";
$userName = $password = $ repeatPassword = $firstName = $lastName = $firstAddress 
$city = $states = $zipCode = $phoneNumber = $email = $Gender = $Status = $birthDay = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
  if (empty($userName)) {
			$userNameErr = "User Name is required";
		} else {
			$userName = test_input($_POST["userName"]);
			if (strlen($userName) > 50 || strlen($userName) < 6)
			{
				$userNameErr = "Must be 6 to 50 characters";
			}
		}

  if (empty($password)) {
			$passwordErr = "Password is required";
		} else {
			$password = test_input($_POST["password"]);
			if (strlen($password) > 50 || strlen($password) < 8)
			{
				$passwordErr = "Must be 8 to 50 characters";
			}
			else if (!preg_match("#[A-Z]+#", $password))
			{
				$passwordErr = "Must contain a capital letter";
			}
			else if (!preg_match("#[a-z]+#",$password))
			{
				$passwordErr = "Must contain a lowercase letter";
			}
			else if (!preg_match("#[0-9]+#", $password))
			{
				$passwordErr = "Must contain a digit";
			}
			else if (!preg_match("/\W/", $password))
			{
				$passwordErr = "Must contain a special character";
			}
		}
		
	if (empty($repeatPassword)) {
			$repeatPasswordErr = "Please confirm password";
		} else {
			$repeatPassword = test_input($_POST["repeatPassword"]);
			if (strlen($repeatPassword) > 50 || strlen($repeatPassword) < 8)
			{
				$repeatPasswordErr = "Must be 8 to 50 characters";
			}
			else if (!preg_match("#[A-Z]+#", $repeatPassword))
			{
				$repeatPasswordErr = "Must contain a capital letter";
			}
			else if (!preg_match("#[a-z]+#",$repeatPassword))
			{
				$repeatPasswordErr = "Must contain a lowercase letter";
			}
			else if (!preg_match("#[0-9]+#", $repeatPassword))
			{
				$repeatPasswordErr = "Must contain a digit";
			}
			else if (!preg_match("/\W/", $repeatPassword))
			{
				$repeatPasswordErr = "Must contain a special character";
			}
			else if ($repeatPassword != $password)
			{
				$repeatPasswordErr = "Passwords do not match";
			}
		}	
	
	if (empty($firstAddress)) {
			$firstAddressErr = "Address is required";
		} else {
			$firstAddress = test_input($_POST["firstAddress"]);
			if (strlen($firstAddress) > 100)
			{
				$firstAddressErr = "Max length of 100 characters";
			}
		}
	if (empty($city)) {
			$cityErr = "City is required";
		} else {
			$city = test_input($_POST["city"]);
			if (strlen($city) > 50)
			{
				$cityErr = "Max length of 50 characters";
			}
		}
	
		if (empty($zipCode)) {
			$zipCodeErr = "Zip code is required";
		} else {
			$zipCode = test_input($_POST["zipCode"]);
			if (preg_match("/[a-zA-Z]/", $zipCode))
			{
				$zipCodeErr = "Must contain only digits";
			}			
			else if (strlen($zipCode) != 10 && strlen($zipCode) != 5)
			{
				$zipCodeErr = "Must be 5 or 9 digits";
			}
			else if (!preg_match("/^[0-9]{5}(-[0-9]{4})?$/", $zipCode))
			{
				$zipCodeErr = "Must be in xxxxx or xxxxx-xxxx format";
			}
		}
	
	if (empty($phoneNumber)) {
			$phoneNumberErr = "Phone number is required";
		} else {
			$phoneNumberErr = test_input($_POST["phoneNumber"]);
			if (preg_match("/[a-zA-Z]/", $phoneNumber))
			{
				$phoneNumberErr = "Must contain only digits";
			}	
			else if (strlen($phoneNumber) != 12)
			{
				$phoneNumberErr = "Must be a 10 digits";
			}
			else if (!preg_match("/^([0-9]{3})-([0-9]{3})-([0-9]{4})/", $phoneNumber))
			{
				$phoneNumberErr = "Must be in xxx-xxx-xxxx format";
			}
		}
		
  if (empty($_POST["firstName"])) {
    $firstNameErr = "First name is required";
  } else {
    $firstName = test_input($_POST["firstName"]);
    // check if name only contains letters 
    if (!preg_match("/^[a-zA-Z ]*$/",$firstName)) {
      $nameErr = "Only letters allowed";
    }
  }
  
  if (empty($_POST["lastName"])) {
    $lastNameErr = "Last Name is required";
  } else {
    $lastName = test_input($_POST["lastName"]);
    // check if name only contains letters 
    if (!preg_match("/^[a-zA-Z ]*$/",$lastName)) {
      $lastNameErr = "Only letters allowed";
    }
  }
  
  if (empty($_POST["email"])) {
    $emailErr = "Email is required";
  } else {
    $email = test_input($_POST["email"]);
    // check if e-mail address is well-formed
    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
      $emailErr = "Invalid email format";
    }
  }

  if (empty($_POST["Gender"])) {
    $GenderErr = "Gender is required";
  } else {
    $Gender = test_input($_POST["Gender"]);
  }
  
  if (empty($_POST["Status"])) {
    $StatusErr = "Status is required";
  } else {
    $Status = test_input($_POST["Status"]);
  }
  
  if (empty($birthDay)) {
	  $birthDayErr = "Date of Birth is required";
	  } else {
		  $birthDay = test_input($_POST["birthDay"]);
		  if (!preg_match("/^((0|1)\d{1})\/((0|1|2)\d{1})\/((19|20)\d{2})/", $birthDay))
		  {
			  $birthDayErr = "Must be proper date in 'MM/dd/yyyy' format";
			  }			
			  }	
  
}

function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}





?>