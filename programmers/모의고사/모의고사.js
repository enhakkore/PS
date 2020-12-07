function solution(answers) {
    const students = [[1,2,3,4,5], [2,1,2,3,2,4,2,5], [3,3,1,1,2,2,4,4,5,5]];
    let maxCount = -1;
    let answer = [];

    students.forEach((student, index) => {
        let count = 0;
        let flag = false;

        for(let i = 0 ; i < answers.length ; i++){
            if(answers[i] === student[i % student.length]){
                flag = true;
                count += 1;
            }
        }

        if(flag){
            if(count > maxCount){
                maxCount = count;
                answer = [index+1];
            } else if(count === maxCount){
                answer.push(index+1);
            }
        }
    });

    return answer;
}
