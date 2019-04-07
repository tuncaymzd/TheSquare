select users.firstname, skills.name from users inner join job_offers on job_offers.id_compagny = 2 inner join hold on 
hold.id_job_offer = job_offers.id_job_offer inner join skills on skills.id_skill = hold.id_skill inner join have on have.id_skill = skills.id_skill
and have.id_user = users.id_user;