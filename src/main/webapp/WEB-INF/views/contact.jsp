<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include  page="/WEB-INF/views/headerFront.jsp"></jsp:include>

	<div class="container mt-60">
		<div class="row justify-content-center">
			<div class="col-12 col-md-8 col-lg-6 pb-5">


				<!--Form with header-->

				<form action="mail.php" method="post">

						<div class="card-body p-3">

							<!--Form body-->
							<div class="form-group">
								<div class="input-group mb-2">
									<div class="input-group-prepend"></div>
									<input type="text" class="form-control" id="nombre"
										name="nombre" placeholder="Nom Prenom" required>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group mb-2">
									<div class="input-group-prepend"></div>
									<input type="email" class="form-control" id="nombre"
										name="email" placeholder="Adresse mail" required>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group mb-2">
									<div class="input-group-prepend"></div>
									<textarea class="form-control" placeholder="Message" required></textarea>
								</div>
							</div>

							<div class="text-center">
								<input type="submit" value="Envoyer"
									class="btn btn-success btn-block rounded-0 py-2">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

<jsp:include  page="/WEB-INF/views/footerFront.jsp"></jsp:include>
