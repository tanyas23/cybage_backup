

	sampleApp.controller('search',function($scope,$location){
		$scope.releaseJSON = [
					{index:0,Title:'brb',Discription:'sad',StartDate:'01-Sep-2014',PlannedDate:'01-Sep-2014',ReleaseDate:'01-Sep-2014',Type:'MileStone',To:'Dev Test',Items:'sad',Status:'Planned',Manager:'Manager',Version:'bre'},
					{index:1,Title:'brb',Discription:'sad',StartDate:'lol',PlannedDate:'sad',ReleaseDate:'sad',Type:'vre',To:'erb',Items:'sad',Status:'ert',Manager:'117StartDate',Version:'bre'},
					{index:2,Title:'brb',Discription:'sad',StartDate:'lol',PlannedDate:'sad',ReleaseDate:'sad',Type:'vre',To:'erb',Items:'sad',Status:'ert',Manager:'117StartDate',Version:'bre'},
					{index:3,Title:'brb',Discription:'sad',StartDate:'lol',PlannedDate:'sad',ReleaseDate:'sad',Type:'vre',To:'erb',Items:'sad',Status:'ert',Manager:'117StartDate',Version:'bre'},
					{index:4,Title:'brb',Discription:'sad',StartDate:'lol',PlannedDate:'sad',ReleaseDate:'sad',Type:'vre',To:'erb',Items:'sad',Status:'ert',Manager:'117StartDate',Version:'bre'}
				];
				
		$scope.iterationJSON = [
					{index:0,Title:'brb',Discription:'sad',StartDate:'01-Sep-2014',EndDate:'01-Sep-2014',Items:'sad',Status:'Planned',Type:'MileStone'},
					{index:1,Title:'brb',Discription:'sad',StartDate:'01-Sep-2014',EndDate:'01-Sep-2014',Items:'sad',Status:'Planned',Type:'MileStone'},
					{index:2,Title:'brb',Discription:'sad',StartDate:'01-Sep-2014',EndDate:'01-Sep-2014',Items:'sad',Status:'Planned',Type:'MileStone'},
					{index:3,Title:'brb',Discription:'sad',StartDate:'01-Sep-2014',EndDate:'01-Sep-2014',Items:'sad',Status:'Planned',Type:'MileStone'},
					{index:4,Title:'brb',Discription:'sad',StartDate:'01-Sep-2014',EndDate:'01-Sep-2014',Items:'sad',Status:'Planned',Type:'MileStone'}
				];
				
		$scope.edit=function(index) {
			//alert($scope.releaseTitle);
			$scope.releaseTitle = $scope.releaseJSON[index].Title;
			$scope.releaseDescription = $scope.releaseJSON[index].Discription;
			$scope.releaseStartDate = $scope.releaseJSON[index].StartDate;
			$scope.releasePlannedDate = $scope.releaseJSON[index].PlannedDate;
			$scope.releaseReleaseDate = $scope.releaseJSON[index].ReleaseDate;
			$scope.releaseType = $scope.releaseJSON[index].Type;
			$scope.releaseTo = $scope.releaseJSON[index].To;
			$scope.releaseItems = $scope.releaseJSON[index].Items;
			$scope.releaseStatus = $scope.releaseJSON[index].Status;
			$scope.releaseManager = $scope.releaseJSON[index].Manager;
			$scope.releaseVersion = $scope.releaseJSON[index].Version;
			$(".container-editRelease").show();
			$(".container-searchRelease").hide();
			$(".container-searchIteration").hide();
			$(".container-editIteration").hide();
			
			
		}
		 $scope.resetForm=function(){
			
			$scope.releaseTitle = "";
			$scope.releaseDescription = "";
			$scope.releaseStartDate = "";
			$scope.releasePlannedDate = "";
			$scope.releaseReleaseDate = ""
			$scope.releaseType = "Type";
			$scope.releaseTo = "To";
			$scope.releaseItems = "";
			$scope.releaseStatus = "Status";
			$scope.releaseManager = "Manager";
			$scope.releaseVersion = "";
			$scope.IterationTitle = "";
			$scope.IterationDescription = "";
			$scope.IterationStartDate = "";
			$scope.IterationEndDate ="";
			$scope.IterationItems = "";			
			$scope.IterationStatus = "Status";
			$scope.IterationType = "Type"; 
			
		} 
					
		$scope.edititeration=function(index) {
			
			
			$location.path('/newiteration');
		/*	
			$scope.IterationTitle = $scope.iterationJSON[index].Title;
			$scope.IterationDescription = $scope.iterationJSON[index].Discription;
			$scope.IterationStartDate = $scope.iterationJSON[index].StartDate;
			$scope.IterationEndDate = $scope.iterationJSON[index].EndDate;
			$scope.IterationItems = $scope.iterationJSON[index].Items;			
			$scope.IterationStatus = $scope.iterationJSON[index].Status;
			$scope.IterationType = $scope.iterationJSON[index].Type;				
		//	$("#IterationTitle").val("sdf");
			alert($scope.iterationJSON[index].Title);
			*/
		}
		
		
	});