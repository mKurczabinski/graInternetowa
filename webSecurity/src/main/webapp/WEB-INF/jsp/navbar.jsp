<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav
	class="navbar navbar-inverse navbar-fixed-top justify-content-between">
	<div class="container-fluid">

		<div class="navbar-header">

			<a class="navbar-brand" href="index"><span
				class="glyphicon glyphicon-home pr10"></span>glosowanko.pl</a>
			<button class="navbar-toggle collapsed" type="button"
				data-toggle="collapse" data-target="#bs-navbar-1"
				aria-controls="bs-navbar-1" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="sr-only"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
		</div>



		<div class="collapse navbar-collapse" id="bs-navbar-1">
			<ul class="nav navbar-nav navbar-right">
			
				<li class="nav-item"><a
					href="${mainPage}profile/${trustedUser.id}">Profil</a></li>
				<li class="nav-item"><a href="${mainPage}newAccount">Załóż
						konto</a></li>
				<li class="nav-item"><a href="howItWorks" id="hiw"
					rel="modal:open">jak to działa</a></li>

			</ul>

		</div>

	</div>
</nav>