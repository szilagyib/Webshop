import React, { Component } from "react";

class Login extends Component {
  
    render() {
        return (
            <div className="auth-wrapper">
                <div className="auth-inner">
                    <form>
                        <h3>Login</h3>
                        <div className="form-group">
                            <label>E-mail</label>
                            <input type="email" className="form-control" placeholder="E-mail" />
                        </div>
                        <div className="form-group">
                            <label>Password</label>
                            <input type="password" className="form-control" placeholder="Password" />
                        </div>
                        <button type="submit" className="button btn-block">Submit</button>
                    </form>
                </div>
            </div>
        );
    }

  }
  export default Login;