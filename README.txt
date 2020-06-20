Requirement 1 - URL to get the specialist details by hospital name and specialist type
http://localhost:8089/getDetails/{hospitalName}?type={specialistType}
Example : http://localhost:8089/getDetails/Greenways%20Hospital?type=Cardiologist

Requirement 2 - URL to Schedule Appointment with a specialist
http://localhost:8089/scheduleAppointment/{hospitalName}?patientName={patientName}&specialistName={specialistName}&appointmentDay={appointmentDay}
Example :http://localhost:8089/scheduleAppointment/Hospital%20BlueFountain?patientName=Jothi&specialistName=John%20Walker&appointmentDay=Tuesday

Requirement 3 - URL to get available number of beds in a hospital
http://localhost:8089/getAvailableBeds/{hospitalName}
Example : http://localhost:8089/getAvailableBeds/Hospital%20BlueFountain

Requirement 4 - URL to test the rest
http://localhost:8089/testRestClient

Requirement 5 - URL to check the health
http://localhost:8089/actuator/health
