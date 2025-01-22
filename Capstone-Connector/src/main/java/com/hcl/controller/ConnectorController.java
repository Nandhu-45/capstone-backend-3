package com.hcl.controller;

//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hcl.entity.Booking;
import com.hcl.entity.BookingConfirmation;
import com.hcl.entity.Owner;
import com.hcl.entity.OwnerConfirmation;
import com.hcl.entity.OwnerMessage;
import com.hcl.entity.User;
import com.hcl.entity.UserMessage;
import com.hcl.entity.Vehicle;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ConnectorController {
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	//get BaseUrl function return the instance of the microService
	private String getBaseUrl(String microServiceName) {
		ServiceInstance instance = loadBalancerClient.choose(microServiceName);
		System.out.println("base url : " + instance.getUri().toString());
		return instance.getUri().toString();
	}

	// *********************************VEHICLE-API'S*******************************************//

	//get all the Vehicles from the Vehicle-MS
	@GetMapping("/GetAllVehicles")
	public List<Vehicle> getAll() {
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Vehicle-MS");
		Vehicle[] courseArray = restTemplate.getForObject(microServiceLocation + "/getallvehicles", Vehicle[].class);
		List<Vehicle> courses = Arrays.asList(courseArray);
		return courses;
	}

 
    //add the vehicle to Vehicle-MS
	@GetMapping("/addvehicle")
	public Vehicle add(String regNumber, String model, String vehiclePic, int wheeler, int pricePerKm) {
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Vehicle-MS");
		Vehicle owner = restTemplate.getForObject(microServiceLocation + "/addVehicle?regNumber=" + regNumber
				+ "&model=" + model + "&vehiclePic=" + vehiclePic + "&wheeler=" + wheeler + "&pricePerKm=" + pricePerKm,
				Vehicle.class);
		return owner;
	}

	// update vehicle in Vehicle-MS
	@GetMapping("/Updatevehicle")
	public Vehicle update(String regNumber, String model, String vehiclePic, int wheeler, int pricePerKm) {
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Vehicle-MS");
		Vehicle owner = restTemplate
				.getForObject(
						microServiceLocation + "/updateVehicle?regNumber=" + regNumber + "&model=" + model
								+ "&vehiclePic=" + vehiclePic + "&wheeler=" + wheeler + "&pricePerKm=" + pricePerKm,
						Vehicle.class);
		return owner;
	}

	// search vehicle by regNumber
	@GetMapping("/getbyregNumber")
	public Vehicle getbyid(String regNumber) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("Vehicle-MS");
		Vehicle courseArray = rt.getForObject(microServiceUrl + "/findbyregNumber?regNumber=" + regNumber,
				Vehicle.class);

		return courseArray;

	}

	// search vehicle by model-name
	@GetMapping("/getbymodelname")
	public Vehicle searchByModelName(String model) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("Vehicle-MS");
		Vehicle courseArray = rt.getForObject(microServiceUrl + "/searchbymodel?model=" + model, Vehicle.class);

		return courseArray;

	}

	//get vehicle by Wheeler
	@GetMapping("/getbyWheeler")
	public List<Vehicle> searchByWheeler(int wheeler) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("Vehicle-MS");
		Vehicle[] courseArray = rt.getForObject(microServiceUrl + "/getallByWheeler?wheeler=" + wheeler,
				Vehicle[].class);
		List<Vehicle> courseL = Arrays.asList(courseArray);
		return courseL;

	}

	// sorting the Vehicle
	@GetMapping("/Sortvehicle")
	public List<Vehicle> SortVehiclebyPrice() {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("Vehicle-MS");
		Vehicle[] courseArray = rt.getForObject(microServiceUrl + "/SortVehicles", Vehicle[].class);

		List<Vehicle> courseL = new ArrayList<Vehicle>();
		for (int i = 0; i < courseArray.length; i++) {
			courseL.add(courseArray[i]);
		}
		return courseL;

	}

	// Delete vehicle by regNumber
	@GetMapping("/DeleteById")
	public String DeleteById(String regNumber) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("Vehicle-MS");
		String courseArray = rt.getForObject(microServiceUrl + "/deletevehicle?regNumber=" + regNumber, String.class);

		return courseArray;

	}
	

	// *************************USER-API'S********************************************//

	// User register
	@GetMapping("/RegisterUser")
	public User addUser(int userId, String userName, String userEmail, String userPassword, String userPic) {
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("User-MS");
		User owner = restTemplate.getForObject(microServiceLocation + "/register?userId=" + userId + "&userName="
				+ userName + "&userEmail=" + userEmail + "&userPassword=" + userPassword + "&userPic=" + userPic,
				User.class);
		return owner;
	}

	// show all users
	@GetMapping("/GetAllUsers")
	public List<User> getAllusers() {
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("User-MS");
		User[] courseArray = restTemplate.getForObject(microServiceLocation + "/getallusers", User[].class);
		List<User> courses = Arrays.asList(courseArray);
		return courses;
	}

	// update user
	@GetMapping("/UpdateUsers")
	public User updateUser(int userId, String userName, String userEmail, String userPassword, String userPic) {
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("User-MS");
		User owner = restTemplate.getForObject(microServiceLocation + "/update?userId=" + userId + "&userName="
				+ userName + "&userEmail=" + userEmail + "&userPassword=" + userPassword + "&userPic=" + userPic,
				User.class);
		return owner;
	}

	// search user by email
	@GetMapping("/searchByEmail")
	public User searchByEmailUser(String userEmail) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("User-MS");
		User courseArray = rt.getForObject(microServiceUrl + "/searchbyuserEmail?userEmail=" + userEmail, User.class);

		return courseArray;

	}

	// search user by name
	@GetMapping("/searchByName")
	public User searchByNameUser(String userName) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("User-MS");
		User courseArray = rt.getForObject(microServiceUrl + "/searchbyuserName?userName=" + userName, User.class);

		return courseArray;

	}

	// get user by user-id
	@GetMapping("/searchByuserID")
	public User searchByuserId(int userId) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("User-MS");
		User courseArray = rt.getForObject(microServiceUrl + "/getbyid?userId=" + userId, User.class);

		return courseArray;

	}

	// login user
	@GetMapping("/userLogin")
	public User UserLogin(String userName, String userPassword) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("User-MS");
		User courseArray = rt.getForObject(
				microServiceUrl + "/login?userName=" + userName + "&userPassword=" + userPassword, User.class);

		return courseArray;

	}

	// logout user
	@GetMapping("/userLogout")
	public String UserLogout(String userName, String userPassword) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("User-MS");
		String courseArray = rt.getForObject(
				microServiceUrl + "/logout?userName=" + userName + "&userPassword=" + userPassword, String.class);

		return courseArray;

	}

	// delete user by user id
	@GetMapping("/deletebyuserId")
	public String deleteByNameUser(int userId) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("User-MS");
		String courseArray = rt.getForObject(microServiceUrl + "/delete?id=" + userId, String.class);

		return courseArray;

	}

	
	// *************************************OWNER-API'S***********************************************//

	// Owner registration
	@GetMapping("/RegisterOwner")
	public Owner addOwner(int ownerId, String ownerName, String ownerEmail, String ownerPassword, String ownerPic) {
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Owner-MS");
		Owner owner = restTemplate.getForObject(microServiceLocation + "/register?ownerId=" + ownerId + "&ownerName="
				+ ownerName + "&ownerEmail=" + ownerEmail + "&ownerPassword=" + ownerPassword + "&ownerPic=" + ownerPic,
				Owner.class);
		return owner;
	}

	// show all owners
	@GetMapping("/showallowners")
	public List<Owner> getAllowners() {
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Owner-MS");
		Owner[] courseArray = restTemplate.getForObject(microServiceLocation + "/getallOwners", Owner[].class);
		List<Owner> courses = Arrays.asList(courseArray);
		return courses;
	}

	// update Owner
	@GetMapping("/UpdateOwner")
	public Owner updateOwner(int ownerId, String ownerName, String ownerEmail, String ownerPassword, String ownerPic) {
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Owner-MS");
		Owner owner = restTemplate.getForObject(microServiceLocation + "/updateOwner?ownerId=" + ownerId + "&ownerName="
				+ ownerName + "&ownerEmail=" + ownerEmail + "&ownerPassword=" + ownerPassword + "&ownerPic=" + ownerPic,
				Owner.class);
		return owner;
	}

	// search owner by email
	@GetMapping("/findbyOwnerEmail")
	public Owner searchByEmailOwner(String ownerEmail) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("Owner-MS");
		Owner courseArray = rt.getForObject(microServiceUrl + "/searchbyOwnerEmail?ownerEmail=" + ownerEmail,
				Owner.class);

		return courseArray;

	}

	// search owner by name
	@GetMapping("/findByOwnerName")
	public Owner searchByNameOwner(String ownerName) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("Owner-MS");
		Owner courseArray = rt.getForObject(microServiceUrl + "/searchbyOwnerName?ownerName=" + ownerName, Owner.class);

		return courseArray;

	}

	// get owner by owner-id
	@GetMapping("/searchByOwnerID")
	public Owner searchByOwnerId(int ownerId) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("Owner-MS");
		Owner courseArray = rt.getForObject(microServiceUrl + "/getbyid?ownerId=" + ownerId, Owner.class);

		return courseArray;

	}

	// Owner login
	@GetMapping("/OwnerLogin")
	public String OwnerLogin(String ownerName, String ownerPassword) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("Owner-MS");
		String courseArray = rt.getForObject(
				microServiceUrl + "/login?ownerName=" + ownerName + "&ownerPassword=" + ownerPassword, String.class);

		return courseArray;

	}

	// Owner logout
	@GetMapping("/OwnerLogout")
	public String OwnerLogout(String ownerName, String ownerPassword) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("Owner-MS");
		String courseArray = rt.getForObject(
				microServiceUrl + "/logout?ownerName=" + ownerName + "&ownerPassword=" + ownerPassword, String.class);

		return courseArray;

	}

	// delete owner by owner-id
	@GetMapping("/deletebyOwnerId")
	public Owner deleteByOwnerId(int ownerId) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("Owner-MS");
		Owner courseArray = rt.getForObject(microServiceUrl + "/deleteOwner?ownerId=" + ownerId, Owner.class);

		return courseArray;

	}
	

	// ********************************BOOKING-API'S**************************************

	// get booking by booking-id
	@GetMapping("/findBookingByitsID")
	public Booking findByidBooking(int bookingId) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("Booking-MS");
		Booking courseArray = rt.getForObject(microServiceUrl + "/getBybookingID?bookingId=" + bookingId,
				Booking.class);

		return courseArray;

	}

	//delete booking by booking-id
	@GetMapping("/deleteBookingById")
	public String deleteBookingById(int id) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("Booking-MS");
		String courseArray = rt.getForObject(microServiceUrl + "/deleteBookingById?id=" + id, String.class);

		return courseArray;

	}

    // add booking
	@GetMapping("/AddnewBooking")
	public Booking addBooking(int id, String pickUpLocation, String droppingLocation, int kms, String bookingDate,
			String regNumber, String userName, String userEmail) {
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
//				LocalDate localDate = LocalDate.parse(bookingDate);
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Booking-MS");
		Booking owner = restTemplate.getForObject(
				microServiceLocation + "/addbooking?id=" + id + "&pickUpLocation=" + pickUpLocation
						+ "&droppingLocation=" + droppingLocation + "&kms=" + kms + "&bookingDate=" + bookingDate
						+ "&regNumber=" + regNumber + "&userName=" + userName + "&userEmail=" + userEmail,
				Booking.class);
		return owner;
	}

	// get booking within date
	@GetMapping("/searchbookingwithinDate")
	public List<Booking> bookingWithin(String from, String to) {
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
//				LocalDate localDatefrom = LocalDate.parse(from, formatter);
//				LocalDate localDateto = LocalDate.parse(to, formatter);

//				return service.getwithindate(localDatefrom, localDateto);
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Booking-MS");
		Booking[] owner = restTemplate.getForObject(microServiceLocation + "/getwithindate?from=" + from + "&to=" + to,
				Booking[].class);

		List<Booking> courses = Arrays.asList(owner);
		return courses;
	}

	// get today's booking
	@GetMapping("/searchbytodaysbooking")
	public List<Booking> getBytodaysbooking() {
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Booking-MS");
		Booking[] owner = restTemplate.getForObject(microServiceLocation + "/getBookingtoday", Booking[].class);

		List<Booking> courses = Arrays.asList(owner);
		return courses;
	}

	//get booking by user-email
	@GetMapping("/bookingsByUser")
	public List<Booking> getUserBookings(String email) {
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Booking-MS");
		Booking[] owner = restTemplate.getForObject(microServiceLocation + "/bookingsByUser?email=" + email,
				Booking[].class);

		List<Booking> courses = Arrays.asList(owner);
		return courses;
	}

	// get all the bookings
	@GetMapping("/allBookings")
	public List<Booking> getAllBookings() {
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Booking-MS");
		Booking[] owner = restTemplate.getForObject(microServiceLocation + "/allBookings", Booking[].class);

		List<Booking> courses = Arrays.asList(owner);
		return courses;
	}
	

	// *******************************confirm-booking***************************************

	// cancel/delete booking by booking-id
	@GetMapping("/deleteConfoBooking")
	public String deleteConfoBooking(int id) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("Booking-MS");
		String courseArray = rt.getForObject(microServiceUrl + "/deleteConfoBooking?id=" + id, String.class);

		return courseArray;

	}

	// get all Confirmed bookings
	@GetMapping("/getAllConfirmedBookings")
	public List<BookingConfirmation> getAllConfirmedBookings() {
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Booking-MS");
		BookingConfirmation[] owner = restTemplate.getForObject(microServiceLocation + "/getAllConfirmedBookings",
				BookingConfirmation[].class);

		List<BookingConfirmation> courses = Arrays.asList(owner);
		return courses;
	}

	// get booking by confirm booking id
	@GetMapping("/searchbybookingConfirmId")
	public BookingConfirmation findbyconfirmBookingID(int confirmId) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("Booking-MS");
		BookingConfirmation courseArray = rt.getForObject(
				microServiceUrl + "/getbyconfirmationID?confirmId=" + confirmId, BookingConfirmation.class);

		return courseArray;

	}

	//add the confirm booking
	@GetMapping("/addNewConfirmBooking")
	public BookingConfirmation addnewconfirmation(int confirmId, String pickUpLocation, String droppingLocation,
			int kms, String confirmDate, String regNumber, String userName, String userEmail) {
//						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
//						LocalDate localDate = LocalDate.parse(bookingDate);
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Booking-MS");
		BookingConfirmation owner = restTemplate.getForObject(
				microServiceLocation + "/addnewconfirmations?confirmId=" + confirmId + "&pickUpLocation="
						+ pickUpLocation + "&droppingLocation=" + droppingLocation + "&kms=" + kms + "&confirmDate="
						+ confirmDate + "&regNumber=" + regNumber + "&userName=" + userName + "&userEmail=" + userEmail,
				BookingConfirmation.class);
		return owner;
	}

	// get booking within date
	@GetMapping("/findtheconfirmationWithin")
	public List<BookingConfirmation> ConfirmationbookingWithin(String from, String to) {
//						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
//						LocalDate localDatefrom = LocalDate.parse(from, formatter);
//						LocalDate localDateto = LocalDate.parse(to, formatter);

//						return service.getwithindate(localDatefrom, localDateto);
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Booking-MS");
		BookingConfirmation[] owner = restTemplate.getForObject(
				microServiceLocation + "/getwithindateConfirmation?from=" + from + "&to=" + to,
				BookingConfirmation[].class);

		List<BookingConfirmation> courses = Arrays.asList(owner);
		return courses;
	}

	// get today's booking
	@GetMapping("/searchBytodayconfirmation")
	public List<BookingConfirmation> getBytodaysConfirmation() {
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Booking-MS");
		BookingConfirmation[] owner = restTemplate.getForObject(microServiceLocation + "/getBookingConfirmtoday",
				BookingConfirmation[].class);

		List<BookingConfirmation> courses = Arrays.asList(owner);
		return courses;
	}

	// ******************************OWNER-CONFIRMATION**********************************//
	
	//add Owner Confirmation Booking
	@GetMapping("/OwnerConfirmBookings")
	public OwnerConfirmation addOwnernewconfirmation(int ownerconfirmationId, String pickUpLocation,
			String droppingLocation, int kms, String ownerconfirmationDate, String regNumber, String userName,
			String userEmail) {
//						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
//						LocalDate localDate = LocalDate.parse(bookingDate);
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Booking-MS");
		OwnerConfirmation owner = restTemplate
				.getForObject(
						microServiceLocation + "/owneraddConfirmations?ownerconfirmationId=" + ownerconfirmationId
								+ "&pickUpLocation=" + pickUpLocation + "&droppingLocation=" + droppingLocation
								+ "&kms=" + kms + "&ownerconfirmationDate=" + ownerconfirmationDate + "&regNumber="
								+ regNumber + "&userName=" + userName + "&userEmail=" + userEmail,
						OwnerConfirmation.class);
		return owner;
	}
		

	// ************************************User-MESSAGES************************************************

	//add User-Message
	@GetMapping("/AddusermessagesContent")
	public UserMessage addContentbyUser(int id, String msg, String msgDate, String userEmail, String userName) {				
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Message-MS");
		UserMessage owner = restTemplate.getForObject(microServiceLocation + "/addMessage?id=" + id + "&msg=" + msg
				+ "&msgDate=" + msgDate + "&userEmail=" + userEmail + "&userName=" + userName, UserMessage.class);
		return owner;
	}

	// show all messages to user
	@GetMapping("/showallMessagestouser")
	public List<UserMessage> getAllmsgContenttoUser() {
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Message-MS");
		UserMessage[] courseArray = restTemplate.getForObject(microServiceLocation + "/getallMessages",
				UserMessage[].class);
		List<UserMessage> courses = Arrays.asList(courseArray);
		return courses;
	}

	// get messages within dates
	@GetMapping("/findmsgsbywithindateByuser")
	public List<UserMessage> getmsgbywithinbyUser(String from, String to) {					
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Message-MS");
		UserMessage[] owner = restTemplate
				.getForObject(microServiceLocation + "/getwithindate?from=" + from + "&to=" + to, UserMessage[].class);

		List<UserMessage> courses = Arrays.asList(owner);
		return courses;
	}

	// get today's messages by user
	@GetMapping("/searchbytodaysmsgsbyUser")
	public List<UserMessage> getBytodaymsgContentByuser() {
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Message-MS");
		UserMessage[] owner = restTemplate.getForObject(microServiceLocation + "/getmessagetoday", UserMessage[].class);

		List<UserMessage> courses = Arrays.asList(owner);
		return courses;
	}

	// delete messages by user-email
	@GetMapping("/deleteMsgbyusinguserEmail")
	public UserMessage deleteuserEmailthroughUser(int id) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("Message-MS");
		UserMessage courseArray = rt.getForObject(microServiceUrl + "/deleteUserMsg?id=" + id, UserMessage.class);

		return courseArray;

	}

	// search user by userEmail 
	@GetMapping("/searchuserEmailbyUser")
	public UserMessage searchByuserEmailByUser(String userEmail) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("Message-MS");
		UserMessage courseArray = rt.getForObject(microServiceUrl + "/findmessageByemail?userEmail=" + userEmail,
				UserMessage.class);

		return courseArray;

	}

	// ************************************Owner-MESSAGES************************************************

	//add the owner message
	@GetMapping("/AddOwnermessagesContent")
	public OwnerMessage addContent(int id, String msgedDate, String adminMsg, String userEmail) {						
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Message-MS");
		OwnerMessage owner = restTemplate.getForObject(microServiceLocation + "/addOwnerMessage?id=" + id
				+ "&msgedDate=" + msgedDate + "&adminMsg=" + adminMsg + "&userEmail=" + userEmail, OwnerMessage.class);
		return owner;
	}

	// show all messages
	@GetMapping("/showallMessages")
	public List<OwnerMessage> getAllmsgContent() {
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Message-MS");
		OwnerMessage[] courseArray = restTemplate.getForObject(microServiceLocation + "/getallMessagesOwner",
				OwnerMessage[].class);
		List<OwnerMessage> courses = Arrays.asList(courseArray);
		return courses;
	}

	// get messages within dates
	@GetMapping("/findmsgsbywithindate")
	public List<OwnerMessage> getmsgbywithin(String from, String to) {						
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Message-MS");
		OwnerMessage[] owner = restTemplate.getForObject(
				microServiceLocation + "/getwithindateOwner?from=" + from + "&to=" + to, OwnerMessage[].class);

		List<OwnerMessage> courses = Arrays.asList(owner);
		return courses;
	}

	// get today's messages
	@GetMapping("/searchbytodaysmsgs")
	public List<OwnerMessage> getBytodaymsgContent() {
		RestTemplate restTemplate = new RestTemplate();
		String microServiceLocation = getBaseUrl("Message-MS");
		OwnerMessage[] owner = restTemplate.getForObject(microServiceLocation + "/getOwnermessagetoday",
				OwnerMessage[].class);

		List<OwnerMessage> courses = Arrays.asList(owner);
		return courses;
	}

	// delete user-messages by owner
	@GetMapping("/deleteuserEmailbyowner")
	public OwnerMessage deleteuserEmailthroughOwner(int id) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("Message-MS");
		OwnerMessage courseArray = rt.getForObject(microServiceUrl + "/deleteOwnerMsg?id=" + id, OwnerMessage.class);

		return courseArray;

	}

	// search the ownerMessage by userEmail
	@GetMapping("/searchuserEmailbyOwner")
	public OwnerMessage searchByuserEmailByOwner(String userEmail) {

		RestTemplate rt = new RestTemplate();
		String microServiceUrl = getBaseUrl("Message-MS");
		OwnerMessage courseArray = rt.getForObject(microServiceUrl + "/findmessageByOwneremail?userEmail=" + userEmail,
				OwnerMessage.class);

		return courseArray;

	}

}
