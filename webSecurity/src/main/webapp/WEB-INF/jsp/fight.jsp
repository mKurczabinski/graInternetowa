<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title><s:message code="menu.mainPage" /></title>
</head>
<body>
	<%@include file="/WEB-INF/incl/menu.app"%>

	Wygrana:	${fight }
	Pozostałe hp: ${hp }
	
	Nick: ${user.name}
	Exp: ${player.exp }
	Wymagany exp: ${player.wymaganyExp }
	Klasa: ${player.characterType }
	Kampania: ${player.campaignLevel }
	Tytuł: ${player.title }
	Poziom broni: ${player.weaponLevel }
	Poziom zbroi: ${player.armorLevel }
	Szybkość ataku: ${player.attackSpeed }
	Damage: ${player.damage }
	Hp postaci: ${player.hp }
	Obrona postaci: ${player.defense }
	Level: ${player.level }

	
</body>
</html>