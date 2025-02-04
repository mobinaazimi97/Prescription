// function fetchScript(url, method) {
async function fetchData() {
    try{
        const response = await fetch('/newPrescriptions', {
            method: 'POST',
            body: JSON.stringify(
                {
                    description: 'this is patients prescription',
                }
            ),
            headers: {
                'Content-Type': 'application/json',
            }
        });

        console.log(response);
        console.log(response.body);

        if(!response.ok){
            throw new Error(response.statusText);
        }

        // const contentDiv = document.getElementById('contentDiv');
        // contentDiv.innerHTML = response.body;

        // todo : has error
        // const json = await response.json();
        // console.log("Info"  + JSON.stringify(json));
        console.log(response.text());

    }catch(error){
        console.log("Error" + error);
    }
}