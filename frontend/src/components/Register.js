import React, { Component } from "react";

class Register extends Component {
  
    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    state = {
        firstName: "",
        lastName: "",
        password: "",
        email: ""
    }

    handleFirstName = (e) => {
        this.setState({firstName: e.target.value});
    }
    
    handleLastName = (e) => {
        this.setState({lastName: e.target.value});
    }

    handleEmail = (e) => {
        this.setState({email: e.target.value});
    }

    handlePassword = (e) => {
        this.setState({password: e.target.value});
    }

    async handleSubmit(){
        const response = await fetch('/users', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(this.state)
        });
    }

    render() {
        return (
            <div className="auth-wrapper">
                <div className="auth-inner">
                    <form>
                        <h3>Register</h3>
                        <div className="form-group">
                            <label>First name</label>
                            <input type="text" className="form-control" placeholder="First name" onChange={this.handleFirstName} />
                        </div>
                        <div className="form-group">
                            <label>Last name</label>
                            <input type="text" className="form-control" placeholder="Last name" onChange={this.handleLastName}/>
                        </div>
                        <div className="form-group">
                            <label>E-mail</label>
                            <input type="email" className="form-control" placeholder="E-mail" onChange={this.handleEmail} />
                        </div>
                        <div className="form-group">
                            <label>Password</label>
                            <input type="password" className="form-control" placeholder="Password" onChange={this.handlePassword} />
                        </div>
                        <button type="submit" className="button btn-block" onClick={this.handleSubmit}>Register</button>
                        <p className="already-registered text-right">
                            Already registered <a href="/login">Login?</a>
                        </p>
                    </form>
                </div>
            </div>
        );
    }
    
  }
  export default Register;