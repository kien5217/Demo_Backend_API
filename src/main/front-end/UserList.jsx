import React ,{Component} from 'react';
import {Button, ButtonGroup,Container,Table} from 'reactstap';
import AppNavbar from './AppNavbar';
import {Link} from 'react-router-dom';
class UserList extends Component{
    constructor(props){
        super(props);
        this.state = {users :[]};
        this.remove = this.remove.bind(this);

    }
    componentDidMount(){
        fetch('/users').then(response => response.json()).then(data => this.setState({users: data}));
    }
    async remove(id){
        await fetch('/users/{userid}',{
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updateUsers =  [...this.state.users].filter(i => i.id !== id);
        });
    }
    render() {
        const {users} = this.state;
        const userList =users.map(user => {
            <tr key={user.id}>
            <td style={{whiteSpace: 'nowrap'}}>{user.name}</td>
            <td>{client.email}</td>
            <td>
                <ButtonGroup>
                    <Button size="sm" color="primary" tag={Link} to={"/clients/" + user.id}>Edit</Button>
                    <Button size="sm" color="danger" onClick={() => this.remove(user.id)}>Delete</Button>
                </ButtonGroup>
            </td>
        </tr>
    });
    return (
        <div>
            <AppNavbar/>
            <Container fluid>
                <div className="float-right">
                    <Button color="success" tag={Link} to="/users/new">Add Client</Button>
                </div>
                <h3>Clients</h3>
                <Table className="mt-4">
                    <thead>
                    <tr>
                        <th width="30%">ID</th>
                        <th width="30%">Name</th>
                        <th width="40%">Email</th>
                    </tr>
                    </thead>
                    <tbody>
                    {userList}
                    </tbody>
                </Table>
            </Container>
        </div>
    );
}
}
export default UserList;

