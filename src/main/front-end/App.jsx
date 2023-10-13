import React,{Component} from 'react';
import './App.css';
import Home from './Home';
import UserList from './UserList';
import UserEdit from './UserEdit';
import {BrowserRouter as Router,Route,Switch } from 'react-router-dom';
class App extends Component{
    render(){
        return( 
            <Router>
                <Switch>
                    <Route path ='/' exact ={true} component ={Home}></Route>
                    <Route path = '/users' exact ={true} component = {UserList}/>
                    <Route path ='/users/{id}' component={UserEdit} />
                </Switch>
            </Router>)
    }
}
export default App;

