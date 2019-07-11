function sparscity_memory_test_monir
%SPARSCITY_MEMORY_TEST_MONIR Summary of this function goes here
%   Detailed explanation goes here
% Sparcity with runtime test by- Moniruzzaman
% Creating 4 sparse tensor with ramdom generated in different sparcity 
%% Main Funtion call
clear all;
     
    % Function Fac1
     tic
     Fac1
     t1 = toc;
     
   
   
     
     % ==================== Function Fac2 ==================
     tic
     Fac2
     t2 = toc;
  
     
     % ============== Function Fac3 ========================
     tic
     Fac3
     t3 = toc;

     
     % ================Function Fac4 ================
     tic
     Fac4
     t4 = toc;
     
  
     
     % ================Function main ================
   %t1 = timeit(Fac1);
   %t2 = timeit(Fac2);
   %t3 = timeit(Fac3);
   %t4 = timeit(Fac4);
   %Fac1
   %Fac2
   %Fac3
   %Fac4
   Time= [t1; t2; t3; t4];
   MemoryUsed= [m1; m2; m3; m4];
   N = [nzx1;nzx2;nzx3;nzx4];
  % M = [1,2,3,4];

   
   %PlotMemory
   PlotTime

   %% Faction Fac1
   function Fac1
       
    %<-- Create a tensor with 1% nonzeroes.
    X1 = sptenrand([100 100 100],0.01); 
    nzx1 = nnz(X1);
    %X1 is a sparse tensor of size 1000 x 1000 x 1000 with 0.01 =  9,950,128 nonzeros
    %X1 is a sparse tensor of size 1000 x 1000 x 1000 with 0.05 = 48,771,767 nonzeros
    
    cp_als(X1, 5);
    %toc
    %t1 = toc;
   % [user,sys] = memory;
    %  --- Memory used by MATLAB process ---
  %  m1 = user.MemUsedMATLAB;
      user1 = memory;
    %  --- Memory used by MATLAB process ---
     m1 = user1.MemUsedMATLAB;
   end

%% Faction Fac2
   function Fac2
      %<-- Create a tensor with 5% nonzeroes.
      X2 = sptenrand([100 100 100],0.05);
       nzx2 = nnz(X2);
      %tic
      cp_als(X2, 5);
      %t2 = toc;
      
      % For memory plot
   %   [user,sys] = memory;
      %  --- Memory used by MATLAB process ---
   %   m2 = user.MemUsedMATLAB;
         user2 = memory;
    %  --- Memory used by MATLAB process ---
     m2 = user2.MemUsedMATLAB;
   end

%% Faction Fac3
   function Fac3
      %<-- Create a tensor with 10% nonzeroes.
      X3 = sptenrand([100 100 100],0.10); 
      nzx3 = nnz(X3);
      cp_als(X3, 5);
      
      % For memory plot
   %   [user,sys] = memory;
      %  --- Memory used by MATLAB process ---
  %    m3 = user.MemUsedMATLAB;
         
      user3 = memory;
    %  --- Memory used by MATLAB process ---
     m3 = user3.MemUsedMATLAB;
   end

%% Faction Fac4
   function Fac4
      %<-- Create a tensor with 20% nonzeroes.
      X4 = sptenrand([100 100 100],0.15);
      nzx4 = nnz(X4);
      cp_als(X4, 5);
      
      % For memory plot
  %    [user,sys] = memory;
  %    m4 = user.MemUsedMATLAB;
       user4 = memory;
    %  --- Memory used by MATLAB process ---
     m4 = user4.MemUsedMATLAB;
   end


%% Faction PlotFigure
   function PlotTime
%figure      
       %%==================
%M = [1,2,3,4];

%%==================
%A = MatrixP(:,1);
%B = MatrixP(:,2);
%P = plot(A,B);
subplot(1,2,1)
 P = plot(N, Time);
%%====================Line width and Marker========================
%p(1).LineWidth = 2;
P.Marker = '*';
legend('CP-ALS')
%%====================X_Y_Label and Title========================
xlabel('Sparcity decreases...'), ylabel('Time in Minitues')
title('Factorization with Sparcity')

%% ========================Plot Memomy here==================

subplot(1,2,2)
 Q = plot(N, MemoryUsed);
%%====================Line width and Marker========================
%p(1).LineWidth = 2;
Q.Marker = '*';
legend('CP-ALS')
%%====================X_Y_Label and Title========================
xlabel('Sparcity decreases...'), ylabel('Memory used in GB')
title('Factorization with Sparcity')



   end

%% Memory used



%  --- Largest array MATLAB can create ---
%user.MaxPossibleArrayBytes
%  --- Memory available for data ---
%user.MemAvailableAllArrays







%% Plot
%% Faction PlotFigure
   function PlotMemory
      
       %%==================
%M = [1,2,3,4];

%%==================
%A = MatrixP(:,1);
%B = MatrixP(:,2);
%P = plot(A,B);
 Q = subplot(M, MemoryUsed);
%%====================Line width and Marker========================
%p(1).LineWidth = 2;
Q.Marker = '*';
legend('CP-ALS')
%%====================X_Y_Label and Title========================
xlabel('Sparcity decreases...'), ylabel('Memory used in GB')
title('Factorization with Sparcity')
   end

%% Memory used



%  --- Largest array MATLAB can create ---
%user.MaxPossibleArrayBytes
%  --- Memory available for data ---
%user.MemAvailableAllArrays






end

