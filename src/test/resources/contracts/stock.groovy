package contracts

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            request {
                name "should get all tires in the stock"
                method GET()
                url '/v1/stocks/all'
            }
            response {
                status 200
                body([
                        "model": "Model X", "season": "summer", "tireModel": "stealth", "price": "1000"

                ])
                headers {
                    contentType("application/json")
                }
            }
        },
        Contract.make {
            request {
                name "should get all tires for a season and a model"
                method GET()
                url $(consumer(regex('^/v1/stocks/Model(X|Y|Z){1}/(summer|winter|all-season){1}$')), producer('/v1/stocks/ModelX/summer'))
            }
            response {
                status 200
                body([
                        "model": "Model X", "season": "summer", "tireModel": "stealth", "price": "1000"

                ])
                headers {
                    contentType("application/json")
                }
            }
        }
]