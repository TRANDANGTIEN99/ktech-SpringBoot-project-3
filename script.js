document.getElementById('registerLink').addEventListener('click', function() {
    document.getElementById('mainContent').innerHTML = `
        <h2>회원가입</h2>
        <form id="registerForm">
            <input type="text" id="username" placeholder="사용자 이름" required />
            <input type="password" id="password" placeholder="비밀번호" required />
            <input type="text" id="nickname" placeholder="닉네임" required />
            <input type="text" id="name" placeholder="이름" required />
            <input type="number" id="age" placeholder="나이" required />
            <input type="email" id="email" placeholder="이메일" required />
            <input type="text" id="phone" placeholder="전화번호" required />
            <button type="submit">가입하기</button>
        </form>
    `;
});

document.getElementById('mainContent').addEventListener('submit', function(event) {
    event.preventDefault();


    const userData = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value,
        nickname: document.getElementById('nickname').value,
        name: document.getElementById('name').value,
        age: document.getElementById('age').value,
        email: document.getElementById('email').value,
        phone: document.getElementById('phone').value
    };

    fetch('http://localhost:8080/api/auth/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
    })
    .then(response => response.json())
    .then(data => {
        alert('가입 성공!');
        console.log(data);
    })
    .catch(error => {
        console.error('오류:', error);
        alert('가입 실패.');
    });
});