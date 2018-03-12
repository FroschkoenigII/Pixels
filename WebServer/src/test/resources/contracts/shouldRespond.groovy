package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'PUT'
		url '/'
		body("")
		headers { header('Content-Type', 'text/plain;charset=ISO-8859-1') }
	}
	response {
		status 200
		body("Greetings from Spring Boot!")
		headers { header('Content-Type': 'text/plain;charset=ISO-8859-1') }
	}
}