import http from 'k6/http';

export const options = {
    stages: [
        { duration: '30s', target: 20 },
        { duration: '5m', target: 100 },
        { duration: '10m', target: 500 },
    ],
    thresholds: { http_req_duration: ['avg<100', 'p(95)<200'] },
    noConnectionReuse: true
};

export default function () {
    let result = http.get('http://localhost:8080/recipes/search?searchResult=새우');
}