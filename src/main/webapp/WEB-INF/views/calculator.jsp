<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset = "UTF-8">
	<title>Calculator</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div class="container mt-5">
		<form id="calculatorForm">
			<div class="form-group">
				<input type="number" class="form-control" id="num1" step="any" placeholder="Enter number 1" required>
			</div>
			<div class="form-group">
				<input type="number" class="form-control" id="num2" step="any" placeholder="Enter number 2" required>
			</div>
			<button type="button" class="btn btn-primary mr-2 operation" data-operation="add">Add</button>
			<button type="button" class="btn btn-primary mr-2 operation" data-operation="subtract">Subtract</button>
			<button type="button" class="btn btn-primary mr-2 operation" data-operation="multiply">Multiply</button>
			<button type="button" class="btn btn-primary operation" data-operation="divide">Divide</button>	
		</form>
		<div id="result" class="mt-3"></div>
	</div>
	<script>
        $(document).ready(function() {
            $('.operation').click(function() {
                // Get operation from button data attribute
                var operation = $(this).data('operation');
                var num1 = $('#num1').val();
                var num2 = $('#num2').val();

                // Make AJAX call to API
                $.ajax({
                    type: 'POST',
                    url: '/calculator',
                    contentType: 'application/json',
                    data: JSON.stringify({
                        num1: num1,
                        num2: num2,
                        operation: operation
                    }),
                    success: function(response) {
                        $('#result').text('Result: ' + response);
                    },
                    error: function(xhr, status, error) {
                        var errorMessage = xhr.responseJSON.error;
                        $('#result').text('Error: ' + errorMessage);
                    }
                });
            });
        });
    </script>
</body>
</html>
	