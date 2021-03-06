package com.example.gardendemo.network

class ResponseThrowable : Exception {
    var code: Int
    override var message: String? = null

/*    constructor(error: ERROR, e: Throwable? = null) : super(e) {
        code = error.getKey()
        errMsg = error.getValue()
    }*/

    constructor(code: Int, msg: String, e: Throwable? = null) : super(e) {
        this.code = code
        this.message = msg
    }

/*    constructor(base: IBaseResponse<*>, e: Throwable? = null) : super(e) {
        this.code = base.code()
        this.errMsg = base.msg()
    }*/
}
