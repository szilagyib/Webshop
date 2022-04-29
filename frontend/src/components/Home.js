import React, { Component } from "react";

class Home extends Component {
  
    state = {
        categories: []
    };
    
    async componentDidMount() {
        const response = await fetch('/categories');
        const body = await response.json();
        this.setState({categories: body});
    }

    render() {
        const {categories} = this.state;

        return (
            <div className="home-page">
                <div className="categories">
                  <div className="image-wrapper">
                  {categories.map(category =>
                    <div key={category.id}>
                        <label>{category.name}</label>
                            <img className="image" src={"./images/" + category.image} alt={category.image}/>
                    </div>   
                  )}
                  </div>
                </div>
            </div>
        );
    }

  }
  export default Home;