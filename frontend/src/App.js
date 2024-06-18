import { useEffect, useState } from "react";

function App() {

    const [apiData, setApiData] = useState('');

    const fetchUsers = async () => {
        const response = await fetch(`/api/users`);
        const data = await response.json();
        console.log(data);
        if (response.ok) {
            setApiData(data);
        }
    };

    useEffect(() => {
        fetchUsers();
    }, []);


    return (
        <div className="App">
            Hi there
            {apiData}
        </div>
    );
}

export default App;
