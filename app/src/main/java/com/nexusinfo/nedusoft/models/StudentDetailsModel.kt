package com.nexusinfo.nedusoft.models

import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by firdous on 12/1/2017.
 */

class StudentDetailsModel : Serializable{
    var studentID: Int = 0
    //[Display(Name = "Admission No.")]
    var admissionNo: String? = null
    var yearID: Int = 0
    //[Display(Name = "Year")]
    var yearName: String? = null
    var combinationID: Int = 0
    //[Display(Name = "Combination")]
    var combination: String? = null
    var applicationID: Int = 0
    //[Display(Name = "Roll No")]
    var rollNo: String? = null
    var courseID: Int = 0
    //[Display(Name = "Course")]
    var courseName: String? = null
    //[Display(Name = "First Name")]
    var firstName: String? = null
    //[Display(Name = "Middle Name")]
    var middleName: String? = null
    //[Display(Name = "Last Name")]
    var lastName: String? = null
    //[Display(Name = "Place of Birth")]
    var placeofBirth: String? = null
    //[Display(Name = "DOB")]
    var dob: String? = null
    var caste: String? = null
    var subCaste: String? = null
    //[Display(Name = "Quota")]
    var quotaName: String? = null
    var adressIdPresent: Int = 0
    var adressIdPermanent: Int = 0
    //[Display(Name = "Mother Tounge")]
    var motherTounge: String? = null
    var categoryID: String? = null
    var category: String? = null
    //[Display(Name = "Medium of Instruction")]
    var mediumofInstruction: String? = null
    //[Display(Name = "Language-I")]
    var ILanguage: String? = null
    var languageID_I: String? = null
    var nationality: Int = 0
    var religion: String? = null
    var quotaID: Int = 0
    var quota: String? = null
    var gender: String? = null
    var brcode: String? = null
    //[Display(Name = "Standard Admitted")]
    var standardAdmitted: String? = null
    var branchId: Int = 0
    var semesterId: Int = 0
    var feeId: Int = 0
    var status: String? = null
    //[Display(Name = "Exam Passed")]
    var examPassed: Int = 0
    //[Display(Name = "Extra Curriculam")]
    var extraCurriculam: String? = null
    //[Display(Name = "Last Institute")]
    var lastInstitute: String? = null
    //[Display(Name = "Course")]
    var noofAttempts: String? = null
    //[Display(Name = "University Roll")]
    var universityRoll: String? = null
    //[Display(Name = "Year of Passing")]
    var yearofPassing: String? = null
    //[Display(Name = "Sports National")]
    var sportsNational: String? = null
    //[Display(Name = "Sports State")]
    var sportsState: String? = null
    var income: String? = null
    //[Display(Name = "Student Mobile")]
    var studentMobile: String? = null
    var passport: String? = null
    var universityID: Int = 0
    //[Display(Name = "University")]
    var universityName: String? = null
    var hostelFeeid: Int = 0
    var transportFeeid: Int = 0
    var cmpid: String? = null
    //[Display(Name = "Language-II")]
    var IILanguage: String? = null

    var languageID_II: String? = null
    //[Display(Name = "Language-III")]
    var IIILanguage: String? = null
    var languageID_III: String? = null
    var waiver: String? = null
    var scholarship: String? = null
    var sectionID: Int = 0
    var section: String? = null
    var sports: String? = null
    //[Display(Name = "Other Activity")]
    var otherActivity: String? = null
    //[Display(Name = "Grade Scored")]
    var gradeScored: String? = null
    //[Display(Name = "TC NO.")]
    var tcno: String? = null
    var uid: String? = null
    //[Display(Name = "Dice No.")]
    var diceNo: String? = null
    var remarks: String? = null
    //[Display(Name = "Sports Level")]
    var sportsLevel: String? = null
    //[Display(Name = "Max Marks")]
    var maxMarks: String? = null
    //[Display(Name = "Obtained Marks")]
    var obtainedMarks: Int = 0
    var percentage: Double = 0.toDouble()
    var hospitalDetailsId: Int = 0
    var familyID: Int = 0
    var addressId: Int = 0
    var photoID: Int = 0
    var photoData: ByteArray? = null
    //[Display(Name = "Fathers Name")]
    //[Required(ErrorMessage = "Fathers Name is required")]
    var fathersName: String? = null
    //[Display(Name = "Mother Name")]
    //[Required(ErrorMessage = "Mother Name is required")]
    var mothersName: String? = null
    //[Display(Name = "Profession")]
    //[Required(ErrorMessage = "Father Profession is required")]
    var fatherprofession: String? = null
    //[Display(Name = "Profession")]
    //[Required(ErrorMessage = "Mother Profession is required")]
    var motherprofession: String? = null
    //[Display(Name = "Qualification")]
    var fatherQualification: String? = null
    //[Display(Name = "Qualification")]
    var motherQualification: String? = null
    //[Display(Name = "Father Income")]
    //[Required(ErrorMessage = "Father Income is required")]
    var fatherAnnualIncome: String? = null
    //[Display(Name = "Mother Income")]
    var manualIncome: String? = null
    //[Display(Name = "Company Name")]
    var fatherCmpName: String? = null
    //[Display(Name = "Company Name")]
    var motherCmpName: String? = null
    //[Display(Name = "Company Address")]
    var fatherCmpAddress: String? = null
    //[Display(Name = "Father Co. Add.")]
    var fatherMobile: String? = null
    //[Display(Name = "Company Mobile")]
    var motherMobile: String? = null
    //[Display(Name = "Father Email")]
    var fatherEmail: String? = null
    //[Display(Name = "Mother Email")]
    var motherEmail: String? = null
    //[Display(Name = "Company Address")]
    var motherCmpAddress: String? = null
    //[Display(Name = "Sibling-I Name")]
    var siblingNameI: String? = null
    //[Display(Name = "Class")]
    var siblingClassI: String? = null
    //[Display(Name = "DOB")]
    var siblingDOBI: String? = null
    //[Display(Name = "Sibling-II Name")]
    var siblingNameII: String? = null
    //[Display(Name = "Class")]
    var siblingClassII: String? = null
    //[Display(Name = "DOB")]
    var siblingDOBII: String? = null
    var hospitalname: String? = null
    //[Display(Name = "Insurance")]
    var medicalInsurance: String? = null
    //[Display(Name = "Policy")]
    var policy: String? = null
    //[Display(Name = "File no.")]
    var fileno: String? = null
    //[Display(Name = "Doctor")]
    var doctorname: String? = null
    //[Display(Name = "Address Line-1")]
    var addressLine1: String? = null
    //[Display(Name = "Address Line-2")]
    var addressLine2: String? = null
    //[Display(Name = "City")]
    var city: String? = null

    var countryStateId: Int = 0
    //[Display(Name = "Pin Code")]
    var postalCode: String? = null
    var addressTypeId: Int = 0
    //[Display(Name = "Branch")]
    var branchName: String? = null
    //[Display(Name = "Admission Sought For")]
    var semester: String? = null
    var examName: String? = null
    var country: String? = null


    var data: ByteArray? = null
    var extension: String? = null

    //[Display(Name = "Nationality")]
    var nationalityName: String? = null
    //[Display(Name = "Medium of Instruction")]
    var mediumofInst: String? = null
    //[Display(Name = "Exam Passed")]
    var exampassedName: String? = null
    //[Display(Name = "Year of Passing")]
    var yop: String? = null

    var totalClass: Int = 0
    var totalPresents: Int = 0
    var percent: Float = 0.toFloat()

    var aCross: String? = null
    var appDate: Date? = null
    var childId: Int = 0
    var emerNo1: String? = null
    var emerNo2: String? = null
    var emerNo3: String? = null
    var ext: String? = null
    var fatherCmpNo: String? = null
    var fatherId: Int = 0
    var msg: String? = null
    var parentsNo: String? = null
    var residentContact: String? = null
    var road: String? = null
    var schoolTransport: String? = null
    var fatherMiddleName: String? = null
    var fatherLastName: String? = null
    var motherMiddleName: String? = null
    var motherLastName: String? = null
    var routeID: Int = 0
    //[Display(Name = "In Case of Emergency.")]
    var inCase: String? = null
    var lastYear: Int = 0
    var lastSyllabus: Int = 0
    var applicationStatus: String? = null

    var admissionTypeID: Int? = null
    var admissionType: String? = null

    var feeDetails: ArrayList<FeeRow>? = null

    var examNames: ArrayList<String>? = null
    var marksDetails: ArrayList<MarksRow>? = null

    //Row for fee details
    class FeeRow : Serializable{
        var feeDesc: String? = null
        var total: Float = 0.toFloat()
        var paid: Float = 0.toFloat()
        var balance: Float = 0.toFloat()

    }

    //Row for marks details
    class MarksRow : Serializable{
        var examName: String? = null
        var subjectName: String? = null
        var facultyFirstName: String? = null
        var facultyMiddleName: String? = null
        var facultyLastName: String? = null
        var passingMarks: Float = 0.toFloat()
        var obtainedMarks: Float = 0.toFloat()
        var maxMarks: Int = 0
        var percentage: Float = 0.toFloat()
        var status: String? = null
    }
}
